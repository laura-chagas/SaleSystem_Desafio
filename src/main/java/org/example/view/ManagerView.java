package org.example.view;

import org.example.service.ManagerUseCase;

import java.util.Scanner;

public class ManagerView {

    static ManagerUseCase managerUseCase;
    static Scanner scan;

    public ManagerView() {
        managerUseCase = new ManagerUseCase();
        scan = new Scanner(System.in);
    }

    public void registerManager() {
        System.out.println("Preencha suas informações: ");
        System.out.print("PRIMEIRO NOME: ");
        String nameView = scan.next();
        System.out.print("EMAIL (Necessário '@' e '.com'): ");
        String emailView = scan.next();
        System.out.print("SENHA (MIN '8' CARACTERES, SEM ESPAÇO): ");
        String passwordView = scan.next();
        if (managerUseCase.registerNewManager(nameView, emailView, passwordView)) {
            logIn();
        } else {
            System.out.println("CAMPOS INVÁLIDOS. ");
        }
    }

    public void logIn() {
        System.out.println("Preencha suas informações: ");
        System.out.print("EMAIL: ");
        String emailView = scan.next();
        scan.nextLine();
        System.out.print("SENHA: ");
        String passwordView = scan.next();
        if (managerUseCase.logIn(emailView, passwordView)) {
            menuManager();
        } else {
            System.out.println("CAMPOS INVÁLIDOS. ");
        }
    }

    public void startManager() {
        System.out.println("VOCÊ DESEJA: ");
        System.out.println("[1] LOGAR    [2] CADASTRAR-SE    [3] VOLTAR AO MENU PRINCIPAL");
        int choiceStart = scan.nextInt();

        do {
            switch (choiceStart) {
                case 1:
                    logIn();
                    break;
                case 2:
                    registerManager();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção Inválida! ");
            }
        } while (choiceStart != 3);
    }

    public void menuManager() {
        int choice;
        do {
            System.out.println("VOCÊ DESEJA: ");
            System.out.println("\t[1] DELETAR GERENTE     [2] VER GERENTES EXISTENTES " +
                    "\n\t[3]EXCLUIR CLIENTE    [4] EXCLUIR VENDEDOR " +
                    "\n\t[5] EXCLUIR PRODUTO        [6] EXCLUIR VENDA      " +
                    "\n\t[7] VER SALÁRIOS DE VENDEDORES       [8]CADASTRAR PRODUTOS  " +
                    "\n\t[9] MOSTRAR EMAILS COM 'zup.com'       [0] SAIR");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Digite o email do gerente que VAI SER DELETADO (Necessário '@' e '.com'): ");
                    String emailViewDelete = scan.next();
                    if (managerUseCase.deleteManager(emailViewDelete)) {
                        System.out.println("Gerente deletado :) ");
                    } else {
                        System.out.println("Email no formato incorreto! ");
                    }
                    break;
                case 2:
                    managerUseCase.showAllManagers();
                    break;
                case 3:
                    System.out.println("Informe o ID do Cliente que será excluído! ");
                    int idCustomerViewDelete = scan.nextInt();
                    if (managerUseCase.deleteCustomer(idCustomerViewDelete)) {
                        System.out.println("Cliente excluído! ");
                    } else {
                        System.out.println("Id inválido, tente novamente! ");
                    }
                    break;
                case 4:
                    System.out.println("Informe o ID do vendedor que será excluído! ");
                    int idSellerDelete = scan.nextInt();
                    if (managerUseCase.deleteSeller(idSellerDelete)) {
                        System.out.println("Vendedor excluido! :) ");
                    } else {
                        System.out.println("Id inválido, tente novamente! ");
                    }
                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("Informe o nome do produto que deseja excluir! ");
                    String nameProductDelete = scan.nextLine();
                    if (managerUseCase.deleteProduct(nameProductDelete)) {
                        System.out.println("Produto deletado :) ");
                    } else {
                        System.out.println("ID incorreto! ");
                    }
                    break;
                case 6:
                    System.out.println("Informe o ID da venda! ");
                    int idSaleDelete = scan.nextInt();
                    if (managerUseCase.deleteSale(idSaleDelete)) {
                        System.out.println("Venda excluida! :) ");
                    } else {
                        System.out.println("Id inválido, tente novamente! ");
                    }
                    break;
                case 7:
                    managerUseCase.showSalespeopleSalary();
                    break;
                case 8:
                    System.out.println("Preencha as informações: ");
                    System.out.print("NOME DO PRODUTO: ");
                    scan.nextLine();
                    String nameProductView = scan.nextLine();

                    System.out.print("PREÇO DO PRODUTO (com ','): ");
                    double priceProductView = scan.nextDouble();

                    if (managerUseCase.registerNewProduct(nameProductView, priceProductView)) {
                        System.out.println("Produto Registrado :)");
                    } else {
                        System.out.println("Formato inválido do nome ou preço, tente novamente! ");
                    }
                    break;
                case 9:
                    managerUseCase.showPeoplesWithBusinessEmail();
                    break;
                case 0:
                    System.out.println("ENCERRANDO...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        } while (choice != 0);

    }
}
