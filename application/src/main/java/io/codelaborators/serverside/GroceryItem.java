package io.codelaborators.serverside;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class GroceryItem {

    protected String name;
    protected double price;
    protected int quantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public GroceryItem(){}

    public GroceryItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void activateSale(double salePercentage) {
        this.price -= this.price * salePercentage;
    }
}
