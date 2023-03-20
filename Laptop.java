package hw_6;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
    private String name;
    private String model;
    private String operatingSystem;
    private int storageSize;
    private int RAMSize;
    private String CPUModel;
    private int price;
    

    public Laptop(String name, String model, String operatingSystem, int storageSize, int RAMSize, String CPUModel, int price) {
        this.name = name;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.storageSize = storageSize;
        this.RAMSize = RAMSize;
        this.CPUModel = CPUModel;
        this.price = price;  
    }

    public boolean validateObject(){
        return true;
    }

    public static List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("model");
        list.add("operatingSystem");
        list.add("storageSize");
        list.add("RAMSize");
        list.add("CPUModel");
        list.add("price");
        return list;
    }

    @Override
    public String toString() {
        return "Ноутбук: (" + name + "): " +
                "модель: " + model +
                ", операционная система: " + operatingSystem +
                ", объем встроенной памяти: " + storageSize +
                ", количество оперативной памяти:" + RAMSize +
                ", модель процессора: " + CPUModel +
                ", цена: " + price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(int storageSize) {
        this.storageSize = storageSize;
    }

    public int getRAMSize() {
        return RAMSize;
    }

    public void setRAMSize(int RAMSize) {
        this.RAMSize = RAMSize;
    }

    public String getCPUModel() {
        return CPUModel;
    }

    public void setCPUModel(String CPUModel) {
        this.CPUModel = CPUModel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
