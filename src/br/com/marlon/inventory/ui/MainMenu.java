package br.com.marlon.inventory.ui;

import br.com.marlon.inventory.service.AssetService;
import java.util.Scanner;

public class MainMenu {
    private AssetService service;
    private Scanner scanner;

    public MainMenu(AssetService service){
        this.service = service;
        this.scanner = new Scanner(System.in);

    }

    public void showMenu(){
        System.out.println();
        System.out.println("====================================");
        System.out.println("         ASSET INVENTORY");
        System.out.println("====================================");
        System.out.println("1 - Register Asset");
        System.out.println("2 - List Asset");
        System.out.println("3 - Find Asset");
        System.out.println("4 - Update Asset");
        System.out.println("5 - Delete Asset");
        System.out.println("0 - Exit");
        System.out.println("------------------------------------");
        System.out.print("Choose an Option: ");
    }

    public void start(){
        int option = -1;
        while (option != 0){
            showMenu();
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("Register Asset");
                    break;

                case 2:
                    System.out.println("List Assets");
                    break;

                case 3:
                    System.out.println("Find Asset");
                    break;

                case 4:
                    System.out.println("Update Asset");
                    break;

                case 5:
                    System.out.println("Delete Asset");
                    break;

                case 0:
                    System.out.println("Closing Application...");
                    break;

                default:
                    System.out.println("Invalid Option");

            }

        }
    }

}
