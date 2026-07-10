package br.com.marlon.inventory.repository;

import br.com.marlon.inventory.database.DatabaseConnection;
import br.com.marlon.inventory.model.Asset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssetRepository {

    private List<Asset> assets = new ArrayList<>();

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
        return assets;
    }

    public Asset findById(int id) {
        for (Asset asset : assets) {
            if (asset.getId() == id) {
                return asset;
            }
        }
        return null;
    }

    public void deleteById(int id){
        assets.removeIf(asset -> asset.getId() == id);
    }


}
