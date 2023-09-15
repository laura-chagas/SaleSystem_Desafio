package org.example.service;

public class ValidationManagerInfos {
    public boolean checkEmail(String emailCheck) {
        return emailCheck.contains("@") && emailCheck.contains(".com");
    }

    public boolean checkName(String nameCheck) {
        return (!nameCheck.isEmpty());
    }

    public boolean checkPassword(String passwordCheck) {
        return (passwordCheck.length() >= 8);
    }


}
