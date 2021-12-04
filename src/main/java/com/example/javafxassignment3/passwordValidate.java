package com.example.javafxassignment3;

import java.util.function.Predicate;

public class passwordValidate implements Predicate<String> {

    @Override
    public boolean test(String emailString) {
        return emailString.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
    }
}
