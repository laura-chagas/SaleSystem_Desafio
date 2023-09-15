package org.example.controller;

import org.example.model.ProductModel;
import org.example.repository.ProductRepository;

public class ProductController {

    ProductModel productModel = new ProductModel();
    ProductRepository productRepository = new ProductRepository();

    public boolean registerNewProduct(String nameController, Double priceController) {
        productModel.setProductName(nameController);
        productModel.setPrice(priceController);
        return productRepository.registerNewProduct(productModel.getProductName(), productModel.getPrice());
    }

    public boolean deleteProduct(String nameProductController) {
        productModel.setProductName(nameProductController);
        return productRepository.deleteProduct(productModel.getProductName());
    }

    public void showAllProducts() {
        productRepository.showAllProducts();
    }
}
