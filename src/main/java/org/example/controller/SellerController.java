package org.example.controller;

import org.example.model.SellerModel;
import org.example.repository.SellerRepository;

public class SellerController {

    SellerRepository sellerRepository = new SellerRepository();
    SellerModel sellerModel = new SellerModel();

    public boolean registerNewSeller(String name, String email, String cpf, double salary) {
        sellerModel.setSellerName(name);
        sellerModel.setEmail(email);
        sellerModel.setCpf(cpf);
        sellerModel.setSalary(salary);
        return sellerRepository.registerNewSeller(sellerModel.getSellerName(), sellerModel.getEmail(), sellerModel.getCpf(), sellerModel.getSalary());
    }

    public boolean logIn(String emailController) {
        sellerModel.setEmail(emailController);
        return sellerRepository.logIn(sellerModel.getEmail());
    }

    public boolean deleteSeller(int idSeller) {
        sellerModel.setIdSeller(idSeller);
        return sellerRepository.deleteSeller(sellerModel.getIdSeller());
    }

    public void showSalespeopleSalary() {
        sellerRepository.showSalespeopleSalary();

    }

}
