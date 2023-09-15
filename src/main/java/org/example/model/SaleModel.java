package org.example.model;

public class SaleModel {
    private int idSale;
    private int amount;
    private double total;

    private int fk_idseller;
    private int fk_idcustomer;
    private int fk_idproduct;

    public int getFk_idseller() {
        return fk_idseller;
    }

    public void setFk_idseller(int fk_idseller) {
        this.fk_idseller = fk_idseller;
    }

    public int getFk_idcustomer() {
        return fk_idcustomer;
    }

    public void setFk_idcustomer(int fk_idcustomer) {
        this.fk_idcustomer = fk_idcustomer;
    }

    public int getFk_idproduct() {
        return fk_idproduct;
    }

    public void setFk_idproduct(int fk_idproduct) {
        this.fk_idproduct = fk_idproduct;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
