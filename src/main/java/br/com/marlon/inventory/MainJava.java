package br.com.marlon.inventory;

import br.com.marlon.inventory.database.DatabaseConnection;
import br.com.marlon.inventory.repository.AssetRepository;
import br.com.marlon.inventory.service.AssetService;
import br.com.marlon.inventory.ui.MainMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class MainJava {
    public static void main(String[] args){
        try (Connection connection = DatabaseConnection.getConnection()){
            System.out.println("Database connection successful!");

        }catch (SQLException e){
            throw new RuntimeException("Error closing the database connection.", e);
        }

        AssetRepository repository = new AssetRepository();
        AssetService service = new AssetService(repository);
        MainMenu menu = new MainMenu(service);

        menu.start();


    }
}
