package io.codelaborators.serverside.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListItem {

    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private double subTotal;
    private boolean isSelected;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getSubTotal(){return subTotal;}

    public boolean getSelected(){
        return isSelected;
    }

    public ListItem(){}

    public ListItem(String name, double subTotal, boolean isSelected) {
        this.name = name;
        this.subTotal = subTotal;
        this.isSelected = isSelected;
    }

    public void selectItem(boolean isItemSelected){
        this.isSelected = isItemSelected;
    }
}
