package br.com.marlon.inventory.repository;

import br.com.marlon.inventory.model.Asset;

import java.util.ArrayList;
import java.util.List;

public class AssetRepository {

    private List<Asset> assets = new ArrayList<>();

    public void save(Asset asset) {
        assets.add(asset);
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
