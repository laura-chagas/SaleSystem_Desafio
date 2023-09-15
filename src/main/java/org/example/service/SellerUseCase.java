package org.example.service;

import org.example.controller.CustomerController;
import org.example.controller.ProductController;
import org.example.controller.SaleController;
import org.example.controller.SellerController;

import javax.print.DocFlavor;

public class SellerUseCase extends ValidationSellerInfos {
    SellerController sellerController = new SellerController();
    SaleController saleController = new SaleController();
    ProductController productController = new ProductController();

    CustomerController customerController = new CustomerController();

    public boolean registerNewSeller(String nameUseCase, String emailUseCase, String cpfUseCase, double salaryUseCase) {
        if (checkName(nameUseCase) && checkEmail(emailUseCase) && checkCpf(cpfUseCase) && checksalary(salaryUseCase)) {
            return sellerController.registerNewSeller(nameUseCase, emailUseCase, cpfUseCase, salaryUseCase);
        }
        return false;
    }

    public boolean logIn(String emailUseCase) {
        if (checkEmail(emailUseCase)) {
            return sellerController.logIn(emailUseCase);
        }
        return false;
    }

    public void showAllProducts() {
        productController.showAllProducts();
    }

    public void changeTotalValueOfSalesThatAreNullToZero() {
        saleController.changeTotalValueOfSalesThatAreNullToZero();
    }

    public void showItemsThatHaveBeenSoldForMoreThanTen() {
        saleController.showItemsThatHaveBeenSoldForMoreThanTen();
    }

    public void showAllSales() {
        saleController.showAllSales();
    }

    public boolean registerNewSale(int amount, Double total, int id_seller, int id_customer, int id_product) {
        return saleController.registerNewSale(amount, total, id_seller, id_customer, id_product);
    }

    public boolean deleteSale(int idSale) {
        return saleController.deleteSale(idSale);
    }

    public boolean registerNewCustomer(String name, String email, String cpf, String address) {
        return customerController.registerNewCustomer(name, email, cpf, address);
    }

}
