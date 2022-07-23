package edu.services;

import edu.validation.ArgumentValidators;

import java.util.Objects;

public class Product extends BaseFields {
    private String name;
    private double price;

    public Product(String name, double price) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.price = validators.numberValidator(price, "Price cannot be less than or equal to zero");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Product{");
        sb.append("uniqueId='").append(uniqueId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
