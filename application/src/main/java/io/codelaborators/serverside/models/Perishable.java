package io.codelaborators.serverside.models;

import io.codelaborators.serverside.GroceryItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Perishable extends GroceryItem {

    @Id
    @GeneratedValue
    protected Long id;

    protected int daysToExpiration;

    public int getDaysToExpiration(){
        return daysToExpiration;
    }

    public Perishable(){}

    public Perishable(String name, double price, int quantity, int daysToExpiration) {
        super(name, price, quantity);
        this.daysToExpiration = daysToExpiration;
    }

    @Override
    public double calculateTotalPrice() {
        if(daysToExpiration <=2){
            return .50 * (price*quantity);
        }
        return price * quantity;
    }
}
