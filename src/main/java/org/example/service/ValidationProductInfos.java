package org.example.service;

public class ValidationProductInfos {
    public boolean checkName(String checkNameProduct) {
        return (!checkNameProduct.isEmpty());
    }

    public boolean checkPrice(double checkPriceProduct) {
        return checkPriceProduct > 0;
    }
}
