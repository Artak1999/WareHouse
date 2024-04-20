package com.rockbite.warehouse.service;

import com.rockbite.warehouse.model.Material;
import com.rockbite.warehouse.model.WareHouse;

public interface MaterialService {
    void addMaterial(Material material, int quantity);
    void removeMaterial(Material type, int quantity);
    void moveMaterial(WareHouse fromWarehouse, Material type, int quantity);
    int getMaterialQuantity(Material materialType);
    int getTotalMaterials();
}
