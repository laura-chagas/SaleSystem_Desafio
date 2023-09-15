package org.example.view;

import java.util.Scanner;

public class MainMenu {
    Scanner scan;
    ManagerView managerView;
    SellerView sellerView;

    public MainMenu() {
        scan = new Scanner(System.in);
        managerView = new ManagerView();
        sellerView = new SellerView();
    }

    public void start() {

        int indentUser;

        do {
            System.out.println("BEM-VINDO AO SISTEMA DE VENDAS");
            System.out.println("Identifique-se: \t[1] VENDEDOR      [2] GERENTE    [0] SAIR");
            indentUser = scan.nextInt();
            switch (indentUser) {
                case 1:
                    sellerView.startSeller();
                    break;
                case 2:
                    managerView.startManager();
                    break;
                case 0:
                    System.out.println("ENCERRANDO...");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida! \n");

            }
        } while (indentUser != 0);

    }


}
