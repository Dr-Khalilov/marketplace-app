package edu.services;

import edu.validation.ArgumentValidators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Market {
    private final String name;
    private final List<User> users;
    private final List<Product> products;


    public Market(String name) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name of market cannot be less than 3 characters");
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();

    }

    public String addUser(User user) {
        boolean isAdd = this.users.add(user);
        return isAdd ? "User successfully added in system \n\n" : "Something went wrong! Try again \n\n";
    }

    public void showAllUsers() {
        System.out.println("Existing users :");
        this.users.forEach(System.out::println);
    }

    public void showAllProducts() {
        System.out.println("Existing products :");
        this.products.forEach(System.out::println);
    }

    public String addProduct(Product product) {
        boolean isAdd = this.products.add(product);
        return isAdd ? "Product successfully added in system \n\n" : "Something went wrong! Try again \n\n";
    }

    public String removeProductById(int id) {
        boolean isRemoved = this.products.removeIf(product -> Objects.equals(product.getUniqueId(), id));
        if (isRemoved) {
            return "Product successfully removed from the system";
        }
        return "Something went wrong! Try again to remove the product";
    }

    public String removeUserById(int id) {
        boolean isRemoved = this.users.removeIf(user -> Objects.equals(user.getUniqueId(), id));
        if (isRemoved) {
            return "User successfully removed from the system";
        }
        return "Something went wrong! Try again to remove the user";
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Market.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("users=" + users)
                .add("products=" + products)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;
        Market market = (Market) o;
        return name.equals(market.name) && users.equals(market.users) && products.equals(market.products);
    }
}
