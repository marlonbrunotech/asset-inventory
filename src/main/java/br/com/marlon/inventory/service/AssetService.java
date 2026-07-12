package br.com.marlon.inventory.service;

import br.com.marlon.inventory.model.Asset;
import br.com.marlon.inventory.repository.AssetRepository;

import java.util.List;

public class AssetService {

    private AssetRepository repository;

    public AssetService(AssetRepository repository){
        this.repository = repository;
    }

    public void save(Asset asset){
        repository.save(asset);
    }

    public List<Asset> findAll(){
        return repository.findAll();
    }

    public Asset findById(int id){
        Asset asset = repository.findById(id);
        if(asset == null){
            throw new IllegalArgumentException("Asset not found.");
        }

        return asset;

    }

    public void deleteById(int id) {
        findById(id);
        repository.deleteById(id);
    }

    public void update(Asset updatedAsset){
        findById(updatedAsset.getId());
        repository.update(updatedAsset);

    }


}
