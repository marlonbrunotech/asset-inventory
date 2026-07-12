package br.com.marlon.inventory.repository;

import br.com.marlon.inventory.database.DatabaseConnection;
import br.com.marlon.inventory.model.Asset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssetRepository {

    public void save(Asset asset) {
        String sql = """
                INSERT INTO assets (
                    hostname,
                    ip,
                    operating_system,
                    manufacturer,
                    model,
                    responsible
                )
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, asset.getHostname());
            statement.setString(2, asset.getIp());
            statement.setString(3, asset.getOperatingSystem());
            statement.setString(4, asset.getManufacturer());
            statement.setString(5, asset.getModel());
            statement.setString(6, asset.getResponsible());

            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException("Error saving asset.", e);
        }
    }

    public List<Asset> findAll() {
        String sql = "SELECT * FROM assets";

        List<Asset> assets = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String hostname = resultSet.getString("hostname");
                String ip = resultSet.getString("ip");
                String operatingSystem = resultSet.getString("operating_system");
                String manufacturer = resultSet.getString("manufacturer");
                String model = resultSet.getString("model");
                String responsible = resultSet.getString("responsible");

                Asset asset = new Asset(id, hostname, ip, operatingSystem, manufacturer, model, responsible);

                assets.add(asset);


            }


        }catch (SQLException e){
            throw new RuntimeException("Error finding assets.", e);
        }
        return assets;
    }

    public Asset findById(int id) {
        String sql = "SELECT * FROM assets WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

                 statement.setInt(1, id);
                 ResultSet resultSet = statement.executeQuery();

                 if (resultSet.next()){
                     int assetId = resultSet.getInt("id");
                     String hostname = resultSet.getString("hostname");
                     String ip = resultSet.getString("ip");
                     String operatingSystem = resultSet.getString("operating_system");
                     String manufacturer = resultSet.getString("manufacturer");
                     String model = resultSet.getString("model");
                     String responsible = resultSet.getString("responsible");

                     Asset asset = new Asset(assetId, hostname, ip, operatingSystem, manufacturer, model, responsible);
                     return asset;

                 }

        }catch (SQLException e){
                 throw new RuntimeException("Asset not found.", e);
        }

        return null;
    }

    public void deleteById(int id){
        String sql = "DELETE FROM assets WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1, id);
            statement.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException("Error deleting asset.", e);
        }

    }

    public void update(Asset asset){
        String sql = "UPDATE assets SET hostname = ?, ip = ?, operating_system = ?, manufacturer = ?, model = ?, responsible = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

                 statement.setString(1, asset.getHostname());
                 statement.setString(2, asset.getIp());
                 statement.setString(3, asset.getOperatingSystem());
                 statement.setString(4, asset.getManufacturer());
                 statement.setString(5, asset.getModel());
                 statement.setString(6, asset.getResponsible());
                 statement.setInt(7, asset.getId());

                 statement.executeUpdate();



        }catch (SQLException e){
            throw new RuntimeException("Error updating asset.", e);
        }

    }


}
