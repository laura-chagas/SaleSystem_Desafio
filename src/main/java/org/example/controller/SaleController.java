package org.example.controller;

import org.example.model.SaleModel;
import org.example.repository.SaleRepository;

public class SaleController {

    SaleRepository saleRepository = new SaleRepository();
    SaleModel saleModel = new SaleModel();

    public boolean registerNewSale(int amount, Double total, int id_seller, int id_customer, int id_product) {
        saleModel.setAmount(amount);
        saleModel.setTotal(total);
        saleModel.setFk_idseller(id_seller);
        saleModel.setFk_idcustomer(id_customer);
        saleModel.setFk_idproduct(id_product);
        return saleRepository.registerNewSale(saleModel.getAmount(), saleModel.getTotal(), saleModel.getFk_idseller(), saleModel.getFk_idcustomer(), saleModel.getFk_idproduct());
    }

    public boolean deleteSale(int idSale) {
        saleModel.setIdSale(idSale);
        return saleRepository.deleteSale(saleModel.getIdSale());
    }

    public void showItemsThatHaveBeenSoldForMoreThanTen() {
        saleRepository.showItemsThatHaveBeenSoldForMoreThanTen();
    }

    public void changeTotalValueOfSalesThatAreNullToZero() {
        saleRepository.changeTotalValueOfSalesThatAreNullToZero();
    }

    public void showAllSales() {
        saleRepository.showAllSales();
    }

}
