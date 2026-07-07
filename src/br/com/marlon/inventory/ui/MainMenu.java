package br.com.marlon.inventory.ui;

import br.com.marlon.inventory.model.Asset;
import br.com.marlon.inventory.service.AssetService;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private AssetService service;
    private Scanner scanner;

    public MainMenu(AssetService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);

    }

    public void showMenu() {
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

    public void start() {
        int option = -1;
        while (option != 0) {
            showMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    registerAsset();
                    break;

                case 2:
                    listAssets();
                    break;

                case 3:
                    findAsset();
                    break;

                case 4:
                    updateAsset();
                    break;

                case 5:
                    deleteAsset();
                    break;

                case 0:
                    System.out.println("Closing Application...");
                    break;

                default:
                    System.out.println("Invalid Option");

            }

        }
    }

    private void registerAsset() {
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

    private void listAssets() {
        List<Asset> assets = service.findAll();
        if (assets.isEmpty()) {
            System.out.println("No assets found.");
            return;
        }

        for (Asset asset : assets) {

            System.out.println("------------------------------------");
            System.out.println("ID: " + asset.getId());
            System.out.println("Hostname: " + asset.getHostname());
            System.out.println("IP: " + asset.getIp());
            System.out.println("Operating System: " + asset.getOperatingSystem());
            System.out.println("Manufacturer: " + asset.getManufacturer());
            System.out.println("Model: " + asset.getModel());
            System.out.println("Responsible: " + asset.getResponsible());

        }

    }

    private void findAsset() {
        System.out.println();
        System.out.print("Enter Asset ID: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        try {

            Asset asset = service.findById(id);

            System.out.println("------------------------------------");
            System.out.println("ID: " + asset.getId());
            System.out.println("Hostname: " + asset.getHostname());
            System.out.println("IP: " + asset.getIp());
            System.out.println("Operating System: " + asset.getOperatingSystem());
            System.out.println("Manufacturer: " + asset.getManufacturer());
            System.out.println("Model: " + asset.getModel());
            System.out.println("Responsible: " + asset.getResponsible());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }


    }

    private void updateAsset() {
        System.out.println();
        System.out.print("Enter Asset ID: ");

        int id = scanner.nextInt();
        scanner.nextLine();

        try {

            Asset asset = service.findById(id);
            System.out.println("------------------------------------");
            System.out.println(asset.getHostname() + " Found. ");
            System.out.print("Enter new Hostname: ");
            String hostname = scanner.nextLine();
            System.out.print("Enter new IP: ");
            String ip = scanner.nextLine();
            System.out.print("Enter new Operating System: ");
            String operatingSystem = scanner.nextLine();
            System.out.print("Enter new Manufacturer: ");
            String manufacturer = scanner.nextLine();
            System.out.print("Enter new Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter new Responsible: ");
            String responsible = scanner.nextLine();

            Asset updatedAsset = new Asset(asset.getId(), hostname, ip, operatingSystem, manufacturer, model, responsible);
            service.update(updatedAsset);
            System.out.println("Asset updated successfully!");


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        }

        private void deleteAsset(){
            System.out.println();
            System.out.print("Enter Asset ID for Delete: ");

            int id = scanner.nextInt();
            scanner.nextLine();

            try {
                Asset asset = service.findById(id);
                service.deleteById(id);
                System.out.println("Asset Deleted Successfully!");
            }

            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }



    }
}




