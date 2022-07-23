package edu.services;

import edu.validation.ArgumentValidators;

import java.util.Objects;

public class User extends BaseFields {
    public String name;
    public String surname;
    private double money;

    public User(String name, String surname, double money) {
        ArgumentValidators validators = new ArgumentValidators();
        this.name = validators.stringValidator(name, "Name cannot be less than 3 characters");
        this.surname = validators.stringValidator(surname, "Surname cannot be less than 3 characters");
        this.money = validators.numberValidator(money, "Money cannot be less than or equal to zero");
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("uniqueId='").append(uniqueId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", money=").append(money);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Double.compare(user.money, money) == 0 && name.equals(user.name) && surname.equals(user.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, money);
    }
}
