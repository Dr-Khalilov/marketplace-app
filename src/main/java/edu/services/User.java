package edu.services;

import edu.validation.ArgumentValidators;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static Integer serialId = 0;
    private final Integer uniqueId = generateId();
    private final String name;
    private final String surname;
    private Double amountOfMoney;
    private List<Product> userProducts;

    public User(String name, String surname, double money) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.surname = validators.stringValidator(surname, "Surname cannot be less than 3 characters");
        this.amountOfMoney = validators.numberValidator(money, "Money cannot be less than or equal to zero");
        this.userProducts = new ArrayList<>();
    }

    public List<Product> getUserProducts() {
        return userProducts;
    }

    public void setUserProducts(List<Product> userProducts) {
        this.userProducts = userProducts;
    }

    public void setAmountOfMoney(Double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
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
        return "User{" +
                "uniqueId=" + uniqueId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", money=" + amountOfMoney +
                ", products=" + userProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return uniqueId.equals(user.uniqueId) && name.equals(user.name) && surname.equals(user.surname) && amountOfMoney.equals(user.amountOfMoney);
    }
}
