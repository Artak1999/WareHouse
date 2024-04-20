package com.rockbite.warehouse.service.impl;

import com.rockbite.warehouse.model.Material;
import com.rockbite.warehouse.model.WareHouse;
import com.rockbite.warehouse.repository.MaterialRepository;
import com.rockbite.warehouse.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    Map<Material,Integer> materials = new HashMap<>();
    List<Material> list = new ArrayList<>();

    @Override
    public void addMaterial(Material type, int quantity) {
        int currentQuantity = materials.getOrDefault(type, 0);
        materials.put(type, currentQuantity + quantity);
    }

    @Override
    public void removeMaterial(Material type, int quantity) {
        int currentQuantity = materials.getOrDefault(type, 0);
        if (currentQuantity >= quantity) {
            materials.put(type, currentQuantity - quantity);
        } else {
            System.out.println("Insufficient quantity of " + type.getName() + " in the warehouse.");
        }
    }

    @Override
    public void moveMaterial(WareHouse fromWarehouse, Material type, int quantity) {
        int availableQuantity = fromWarehouse.getQuantity();
        if (availableQuantity >= quantity) {
            removeMaterial(type, quantity);
            this.addMaterial(type, quantity);
        } else {
            System.out.println("Insufficient quantity of " + type.getName() + " in the source warehouse.");
        }
    }

    @Override
    public int getMaterialQuantity(Material materialType) {
        return materials.getOrDefault(materialType, 0);
    }

    @Override
    public int getTotalMaterials() {
        return materials.size();
    }

    public List<Material> getAllMaterialsFromMap(){
        for(Map.Entry<Material, Integer> entry : materials.entrySet())
            list.add(entry.getKey());
        return list;
    }

    public List<Material> getAllMaterials(){
        return materialRepository.findAll();
    }

    public void delete(Long id){
        materialRepository.deleteById(id);
    }
}
