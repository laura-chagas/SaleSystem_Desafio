package org.example.service;

public class ValidationSellerInfos {
    public boolean checkEmail(String emailCheck) {
        return emailCheck.contains("@") && emailCheck.contains(".com");
    }

    public boolean checkName(String nameCheck) {
        return (!nameCheck.isEmpty());
    }

    public boolean checkCpf(String cpf) {
        return cpf.length() > 11;
    }

    public boolean checksalary(double salary) {
        return salary > 0;
    }

}
