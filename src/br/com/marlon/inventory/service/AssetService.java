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
            throw new IllegalArgumentException("Ativo não encontrado.");
        }

        return asset;

    }

    public void deleteById(int id) {
        findById(id);
        repository.deleteById(id);
    }

    public void update(Asset updatedAsset){
        Asset existingAsset = findById(updatedAsset.getId());

        existingAsset.setHostname(updatedAsset.getHostname());
        existingAsset.setIp(updatedAsset.getIp());
        existingAsset.setOperatingSystem(updatedAsset.getOperatingSystem());
        existingAsset.setManufacturer(updatedAsset.getManufacturer());
        existingAsset.setModel(updatedAsset.getModel());
        existingAsset.setResponsible(updatedAsset.getResponsible());

    }


}
