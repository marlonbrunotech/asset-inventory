package br.com.marlon.inventory.ui;

import br.com.marlon.inventory.model.Asset;
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
        System.out.println("2 - List Assets");
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
                    registerAsset();
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

    private void registerAsset(){
        System.out.println();
        System.out.println("===== REGISTER NEW ASSET =====");
        System.out.print("Enter Asset ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Hostname: ");
        String hostname = scanner.nextLine();
        System.out.print("Enter Ip: ");
        String ip = scanner.nextLine();
        System.out.print("Enter Operating System: ");
        String operatingSystem = scanner.nextLine();
        System.out.print("Enter Manufacturer: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Responsible: ");
        String responsible = scanner.nextLine();

        Asset asset = new Asset(id, hostname, ip, operatingSystem, manufacturer, model, responsible);
        service.save(asset);
        System.out.println("Asset registered successfully!");


    }


}
