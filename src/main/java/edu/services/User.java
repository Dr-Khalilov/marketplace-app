package edu.services;

import edu.validation.ArgumentValidators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private static Integer serialId = 0;
    private Integer uniqueId = generateId();
    public String name;
    public String surname;
    private Double money;
    private List<Product> uProducts;

    public List<Product> getuProducts() {
        return uProducts;
    }

    public void setuProducts(List<Product> uProducts) {
        this.uProducts = uProducts;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getMoney() {
        return money;
    }

    public User(String name, String surname, double money) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.surname = validators.stringValidator(surname, "Surname cannot be less than 3 characters");
        this.money = validators.numberValidator(money, "Money cannot be less than or equal to zero");
        this.uProducts = new ArrayList<>();
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
        return "User{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", money=" + money +
                ", products=" + uProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return uniqueId.equals(user.uniqueId) && name.equals(user.name) && surname.equals(user.surname) && money.equals(user.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId, name, surname, money);
    }
}
