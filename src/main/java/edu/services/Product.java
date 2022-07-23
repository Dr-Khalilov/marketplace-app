package edu.services;

import edu.validation.ArgumentValidators;

import java.util.Objects;

public class Product {
    private  static Integer serialId = 0;
    private Integer uniqueId = generateId();
    public String name;

    public Double getPrice() {
        return price;
    }

    private Double price;

    public Product(String name, double price) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.price = validators.numberValidator(price, "Price cannot be less than or equal to zero");
    }

    private Integer generateId(){
        this.serialId++;
        return this.serialId;
    }
    public Integer getUniqueId() {
        return uniqueId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return uniqueId.equals(product.uniqueId) && name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, name, price);
    }
}
