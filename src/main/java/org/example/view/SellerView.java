package org.example.view;


import org.example.service.SellerUseCase;

import java.util.Scanner;

public class SellerView {
    static Scanner scan;
    SellerUseCase sellerUseCase;

    public SellerView() {
        scan = new Scanner(System.in);
        sellerUseCase = new SellerUseCase();
    }

    public void registerSeller() {
        System.out.println("Preencha suas informações: ");
        System.out.print("PRIMEIRO NOME: ");
        String nameView = scan.next();
        System.out.print("EMAIL (Necessário '@' e '.com'): ");
        String emailView = scan.next();
        System.out.print("CPF: ");
        String cpfView = scan.next();
        System.out.println("SALÁRIO (ex: 1200,00) : ");
        double salaryView = scan.nextDouble();
        if (sellerUseCase.registerNewSeller(nameView, emailView, cpfView, salaryView)) {
            logIn();
        } else {
            System.out.println("CAMPOS INVÁLIDOS. ");
        }
    }

    public void logIn() {
        System.out.println("Preencha seu email: ");
        System.out.print("EMAIL: ");
        String emailView = scan.next();
        if (sellerUseCase.logIn(emailView)) {
            menuSeller();
        } else {
            System.out.println("CAMPOS INVÁLIDOS. ");
        }

    }

    public void startSeller() {
        System.out.println("VOCÊ DESEJA: ");
        System.out.println("[1] LOGAR    [2] CADASTRAR-SE    [3] VOLTAR AO MENU PRINCIPAL");
        int choiceStart = scan.nextInt();

        do {
            switch (choiceStart) {
                case 1:
                    logIn();
                    break;
                case 2:
                    registerSeller();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção Inválida! ");
            }
        } while (choiceStart != 3);
    }

    public void menuSeller() {
        int choice;
        do {
            System.out.println("VOCÊ DESEJA: ");
            System.out.println("\t[1] VER PRODUTOS         [2] ALTERA VALOR DA VENDA NULL PRA 0 " +
                    "\n\t[3] VER VENDAS ACIMA DE 10 REAIS        [4] VER TODAS VENDAS " +
                    "\n\t[5] REGISTRA VENDAS            [6] EXCLUIR VENDA " +
                    "\n\t[7] REGISTRAR CLIENTE        [0] SAIR");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    sellerUseCase.showAllProducts();
                    break;
                case 2:
                    sellerUseCase.changeTotalValueOfSalesThatAreNullToZero();
                    break;
                case 3:
                    sellerUseCase.showItemsThatHaveBeenSoldForMoreThanTen();
                    break;
                case 4:
                    sellerUseCase.showAllSales();
                    break;
                case 5:
                    System.out.println("Preencha as informações: ");
                    System.out.print("QUANTIDADE DE PRODUTOS: ");
                    scan.nextLine();
                    int amountProductsView = scan.nextInt();

                    System.out.print("VALOR TOTAL (ex: 2,50): ");
                    Double totalProductsView = scan.nextDouble();

                    System.out.print("ID DO VENDEDOR: ");
                    int idSellerView = scan.nextInt();

                    System.out.print("ID DO CLIENTE: ");
                    int idCustomerView = scan.nextInt();

                    System.out.print("ID DO PRODUTO: ");
                    int idProductView = scan.nextInt();

                    if (sellerUseCase.registerNewSale(amountProductsView, totalProductsView, idSellerView, idCustomerView, idProductView)) {
                        System.out.println("Venda Registrada :)");
                    } else {
                        System.out.println("Formato inválido em algum dos campos, tente novamente! ");
                    }
                    break;
                case 6:
                    System.out.print("INFORME O ID DA VENDA A SER EXCLUÍDA: ");
                    int idSaleView = scan.nextInt();
                    if (sellerUseCase.deleteSale(idSaleView)) {
                        System.out.println("Venda excluída :) ");
                    } else {
                        System.out.println("Id inválido, tente novamente! ");
                    }
                    break;
                case 7:
                    System.out.println("Preencha suas informações: ");
                    System.out.print("PRIMEIRO NOME: ");
                    String nameView = scan.next();
                    System.out.print("EMAIL (Necessário '@' e '.com'): ");
                    String emailView = scan.next();
                    System.out.print("CPF: ");
                    String cpfView = scan.next();

                    System.out.println("ENDEREÇO (ex: Rua example, 451) : ");
                    scan.nextLine();
                    String addressView = scan.nextLine();

                    if (sellerUseCase.registerNewCustomer(nameView, emailView, cpfView, addressView)) {
                        System.out.println("Cliente cadastrado! ");
                    } else {
                        System.out.println("CAMPOS INVÁLIDOS. ");
                    }
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
