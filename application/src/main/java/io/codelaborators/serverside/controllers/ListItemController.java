package io.codelaborators.serverside.controllers;

import io.codelaborators.serverside.models.ListItem;
import io.codelaborators.serverside.repositories.ListItemRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
public class ListItemController {

    @Resource
    private ListItemRepository listItemRepo;

    @GetMapping("/list-items")
    public Collection<ListItem> getListItems(){
        return (Collection<ListItem>) listItemRepo.findAll();
    }

    @GetMapping("/list-items/total-price")
    public String getTotalPrice(){
        Collection<ListItem> listItems = (Collection<ListItem>) listItemRepo.findAll();
        double totalPrice = 0;
        for(ListItem item : listItems){
            totalPrice += item.getSubTotal();
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(totalPrice);
    }

    @PostMapping("/list-items/add-item")
    public Collection<ListItem> addItem(@RequestBody String body) throws JSONException {
        JSONObject newItem = new JSONObject(body);
        String itemName = newItem.getString("name");
        double itemSubtotal = newItem.getDouble("subTotal");
        boolean itemIsSelected = newItem.getBoolean("isSelected");
        Optional<ListItem> itemToAddOpt = listItemRepo.findByName(itemName);
        //add item if not already in the database
        if (itemToAddOpt.isEmpty()) {
            ListItem itemToAdd = new ListItem(itemName, itemSubtotal, itemIsSelected);
            listItemRepo.save(itemToAdd);
        }
        return (Collection<ListItem>) listItemRepo.findAll();
    }

    @PutMapping ("/list-items/{id}/select-item")
    public Collection<ListItem> selectItem(@PathVariable Long id, @RequestBody String body) throws JSONException {
        JSONObject newItem = new JSONObject(body);
        boolean itemIsSelected = newItem.getBoolean("isSelected");
        Optional<ListItem> itemToSelectOpt = listItemRepo.findById(id);

        if (itemToSelectOpt.isPresent()) {
            itemToSelectOpt.get().selectItem(itemIsSelected);
            listItemRepo.save(itemToSelectOpt.get());
        }
        return (Collection<ListItem>) listItemRepo.findAll();
    }

    @DeleteMapping("/list-items/{id}/delete-item")
    public Collection<ListItem> deleteItem(@PathVariable Long id) throws JSONException {
        Optional<ListItem> itemToRemoveOpt = listItemRepo.findById(id);
        if(itemToRemoveOpt.isPresent()){
            listItemRepo.delete(itemToRemoveOpt.get());
        }
        return (Collection<ListItem>) listItemRepo.findAll();
    }
}
