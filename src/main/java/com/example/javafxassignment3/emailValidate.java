package com.example.javafxassignment3;

import java.util.function.Predicate;

public class emailValidate implements Predicate<String> {

    @Override
    public boolean test(String emailString) {
        return emailString.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
}
