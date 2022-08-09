package io.codelaborators.serverside.models;

import io.codelaborators.serverside.GroceryItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NonPerishable extends GroceryItem {

    @Id
    @GeneratedValue
    protected Long id;

    protected boolean toBeDonated;

    public Long getId() {
        return id;
    }

    public boolean getToBeDonated(){
        return toBeDonated;
    }

    public NonPerishable() {
    }

    public NonPerishable(String name, double price, int quantity, boolean toBeDonated) {
        super(name, price, quantity);
        this.toBeDonated = toBeDonated;
    }

    @Override
    public double calculateTotalPrice() {
        if(quantity >=10){
            return .90 * (price * quantity);
        }
        return price * quantity;
    }

    public void activateDonationProcess(){
        toBeDonated = true;
    }
}
