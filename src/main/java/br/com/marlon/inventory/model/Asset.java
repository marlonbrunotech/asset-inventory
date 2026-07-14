package br.com.marlon.inventory.model;

import java.time.LocalDate;

public class Asset {

    private int id;
    private String hostname;
    private String ip;
    private String operatingSystem;
    private String manufacturer;
    private String model;
    private String responsible;
    private AssetStatus status;
    private String location;
    private String lastLoggedUser;
    private LocalDate purchaseDate;

    public Asset() {
    }

    public Asset(String hostname, String ip, String operatingSystem, String manufacturer, String model, String responsible, AssetStatus status, String location, String lastLoggedUser, LocalDate purchaseDate) {
        this.hostname = hostname;
        this.ip = ip;
        this.operatingSystem = operatingSystem;
        this.manufacturer = manufacturer;
        this.model = model;
        this.responsible = responsible;
        this.status = status;
        this.location = location;
        this.lastLoggedUser = lastLoggedUser;
        this.purchaseDate = purchaseDate;
    }

    public Asset(int id, String hostname, String ip, String operatingSystem, String manufacturer, String model, String responsible, AssetStatus status, String location, String lastLoggedUser, LocalDate purchaseDate) {
        this.id = id;
        this.hostname = hostname;
        this.ip = ip;
        this.operatingSystem = operatingSystem;
        this.manufacturer = manufacturer;
        this.model = model;
        this.responsible = responsible;
        this.status = status;
        this.location = location;
        this.lastLoggedUser = lastLoggedUser;
        this.purchaseDate = purchaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public AssetStatus getStatus() {
        return status;
    }

    public void setStatus(AssetStatus status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLastLoggedUser() {
        return lastLoggedUser;
    }

    public void setLastLoggedUser(String lastLoggedUser) {
        this.lastLoggedUser = lastLoggedUser;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
