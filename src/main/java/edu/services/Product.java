package edu.services;

import edu.validation.ArgumentValidators;

public class Product {
    private static Integer serialId = 0;
    private final Integer uniqueId = generateId();
    public String name;
    private final Double price;

    public Product(String name, double price) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.price = validators.numberValidator(price, "Price cannot be less than or equal to zero");
    }

    public Double getPrice() {
        return price;
    }

    private Integer generateId() {
        serialId++;
        return serialId;
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
}
