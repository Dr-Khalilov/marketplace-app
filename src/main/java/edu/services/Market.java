package edu.services;

import edu.validation.ArgumentValidators;

import java.util.*;
import java.util.stream.Stream;

public class Market {
    private final String name;
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();



    public Market(String name) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name of market cannot be less than 3 characters");
    }

    public String addUser(User user) {
        boolean isAdd = this.users.add(user);
        return isAdd ? "User successfully added in system \n\n" : "Something went wrong! Try again \n\n";
    }

    public void showAllUsers() {
        System.out.println("Existing users :");
        this.users.stream().forEach(System.out::println);
    }

    public void showAllProducts() {
        this.products.stream().forEach(System.out::println);
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

    public List<User> getUsers(){
        return this.users;
    }

    public List<Product> getProducts(){
        return this.products;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Market{");
        sb.append("name='").append(name).append('\'');
        sb.append(", users=").append(users);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;
        Market market = (Market) o;
        return name.equals(market.name) && users.equals(market.users) && products.equals(market.products);
    }
}
