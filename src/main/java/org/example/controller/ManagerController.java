package org.example.controller;

import org.example.model.ManagerModel;
import org.example.repository.ManagerRepository;

public class ManagerController {
    ManagerRepository managerRepository = new ManagerRepository();
    ManagerModel managerModel = new ManagerModel();

    public boolean registerNewManager(String nameController, String emailController, String passwordController) {
        managerModel.setName(nameController);
        managerModel.setEmail(emailController);
        managerModel.setPassword(passwordController);
        return managerRepository.registerNewManager(managerModel.getName(), managerModel.getEmail(), managerModel.getPassword());
    }

    public boolean logIn(String emailController, String passwordController) {
        managerModel.setEmail(emailController);
        managerModel.setPassword(passwordController);
        return managerRepository.logIn(managerModel.getEmail(), managerModel.getPassword());
    }

    public boolean deleteManager(String emailController) {
        managerModel.setEmail(emailController);
        return managerRepository.deleteManager(managerModel.getEmail());
    }

    public void showAllManagers() {
        managerRepository.showAllManagers();
    }

    public void showPeoplesWithBusinessEmail() {
        managerRepository.showPeoplesWithBusinessEmail();
    }

}
