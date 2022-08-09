package io.codelaborators.serverside.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pepper extends Perishable{

    @Id
    @GeneratedValue
    private Long id;

    private String imageUrl;

    public Long getId() {
        return id;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public Pepper() {}

    public Pepper(String name, double price, int quantity, int daysToExpiration, String imageUrl) {
        super(name, price, quantity, daysToExpiration);
        this.imageUrl = imageUrl;
    }
}
