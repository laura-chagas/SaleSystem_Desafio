package org.example.controller;

import org.example.model.CustomerModel;
import org.example.repository.CustomerRepository;

public class CustomerController {
    CustomerRepository customerRepository = new CustomerRepository();
    CustomerModel customerModel = new CustomerModel();

    public boolean registerNewCustomer(String name, String email, String cpf, String address) {
        customerModel.setCustomerName(name);
        customerModel.setEmail(email);
        customerModel.setCpf(cpf);
        customerModel.setAddress(address);
        return customerRepository.registerNewCustomer(customerModel.getCustomerName(), customerModel.getEmail(), customerModel.getCpf(), customerModel.getAddress());
    }

    public boolean deleteCustomer(int idCustomer) {
        customerModel.setIdCustomer(idCustomer);
        return customerRepository.deleteCustomer(customerModel.getIdCustomer());
    }
}
