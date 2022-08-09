package io.codelaborators.serverside.controllers;

import io.codelaborators.serverside.models.Apple;
import io.codelaborators.serverside.repositories.AppleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
public class AppleController {

    @Resource
    private AppleRepository appleRepo;

    @GetMapping("/apples")
    public Collection<Apple> getApples(){
        return (Collection<Apple>) appleRepo.findAll();
    }

    @GetMapping("/apples/{id}")
    public Optional<Apple> getApple(@PathVariable Long id){
        return appleRepo.findById(id);
    }

    @GetMapping("/apples/{id}/total-price")
    public String getTotalPrice(@PathVariable Long id){
        Apple appleToFind  = appleRepo.findById(id).get(); //take the OPTIONAL and grab the object from it
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return "The total price of " + appleToFind.getName() + " is " +
                formatter.format(appleToFind.calculateTotalPrice());
    }
}
