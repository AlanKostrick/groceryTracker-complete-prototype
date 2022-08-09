package io.codelaborators.serverside.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Beans extends NonPerishable{

    @Id
    @GeneratedValue
    private Long id;

    private String imageUrl;

    @Override
    public Long getId() {
        return id;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public Beans() {
    }

    public Beans(String name, double price, int quantity, boolean toBeDonated, String imageUrl) {
        super(name, price, quantity, toBeDonated);
        this.imageUrl = imageUrl;
    }
}
