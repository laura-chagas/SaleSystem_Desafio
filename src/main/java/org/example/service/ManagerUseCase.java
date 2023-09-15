package org.example.service;

import org.example.controller.*;

public class ManagerUseCase extends ValidationManagerInfos {
    ManagerController managerController = new ManagerController();
    ValidationProductInfos validationProductInfos = new ValidationProductInfos();
    ProductController productController = new ProductController();
    SaleController saleController = new SaleController();
    SellerController sellerController = new SellerController();

    CustomerController customerController = new CustomerController();

    public boolean registerNewManager(String nameUseCase, String emailUseCase, String passwordUseCase) {
        if (checkName(nameUseCase) && checkEmail(emailUseCase) && checkPassword(passwordUseCase)) {
            return managerController.registerNewManager(nameUseCase, emailUseCase, passwordUseCase);
        }
        return false;
    }

    public boolean logIn(String emailUseCase, String passwordUseCase) {
        if (checkEmail(emailUseCase) && checkPassword(passwordUseCase)) {
            return managerController.logIn(emailUseCase, passwordUseCase);
        }
        return false;
    }

    public boolean deleteManager(String emailUseCase) {
        if (checkEmail(emailUseCase)) {
            return managerController.deleteManager(emailUseCase);
        }
        return false;
    }

    public void showAllManagers() {
        managerController.showAllManagers();
    }

    public boolean registerNewProduct(String nameUseCase, Double priceUseCase) {
        if (validationProductInfos.checkName(nameUseCase) && validationProductInfos.checkPrice(priceUseCase)) {
            return productController.registerNewProduct(nameUseCase, priceUseCase);
        }
        return false;
    }

    public boolean deleteProduct(String nameProductUseCase) {
        return productController.deleteProduct(nameProductUseCase);
    }

    public boolean deleteSale(int idSale) {
        return saleController.deleteSale(idSale);
    }

    public boolean deleteSeller(int idSeller) {
        return sellerController.deleteSeller(idSeller);
    }

    public void showSalespeopleSalary() {
        sellerController.showSalespeopleSalary();
    }

    public boolean deleteCustomer(int idCustomer) {
        return customerController.deleteCustomer(idCustomer);
    }

    public void showPeoplesWithBusinessEmail() {
        managerController.showPeoplesWithBusinessEmail();
    }

}