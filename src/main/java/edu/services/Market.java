package edu.services;

import edu.validation.ArgumentValidators;

import java.util.ArrayList;
import java.util.Objects;

public class Market {
    private final String name;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();


    public Market(String name) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name of market cannot be less than 3 characters");
    }

    public String addUser(User user) {
        boolean isAdd = this.users.add(user);
        return isAdd ? "User successfully added in system" : "Something went wrong! Try again";
    }

    public String removeUserById(String id) {
        boolean isRemoved = this.users.removeIf(user -> Objects.equals(user.getUniqueId(), id));
        if (isRemoved) {
            return "User successfully removed from the system";
        }
        return "Something went wrong! Try again to remove the user";
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

    @Override
    public int hashCode() {
        return Objects.hash(name, users, products);
    }
}
