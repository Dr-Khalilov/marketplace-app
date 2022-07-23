package edu.services;

import edu.validation.ArgumentValidators;

import java.util.Objects;

public class User {
    private static Integer serialId = 0;
    private Integer uniqueId = generateId();
    public String name;
    public String surname;
    private Double money;

    public User(String name, String surname, double money) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.surname = validators.stringValidator(surname, "Surname cannot be less than 3 characters");
        this.money = validators.numberValidator(money, "Money cannot be less than or equal to zero");
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
