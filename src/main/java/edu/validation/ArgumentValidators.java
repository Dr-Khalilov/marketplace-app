package edu.validation;

public class ArgumentValidators {
    public double numberValidator(double number, String message) throws ArithmeticException {
        if (number <= 0) {
            throw new ArithmeticException(message);
        }
        return number;
    }

    public String stringValidator(String value, String message) throws NullPointerException, IllegalArgumentException {
        if (value.isBlank()) {
            String nameParameter = message.split(" ")[0];
            throw new NullPointerException(nameParameter + " cannot be null");
        }
        if (value.strip().length() < 3) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }
}
