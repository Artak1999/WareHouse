package com.rockbite.warehouse.service.impl;

import com.rockbite.warehouse.model.WareHouse;
import com.rockbite.warehouse.repository.WareHouseRepository;
import com.rockbite.warehouse.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Override
    public List<WareHouse> getAll(){
        return wareHouseRepository.findAll();
    }

    @Override
    public void addWareHouse(WareHouse wareHouse) {
        wareHouseRepository.save(wareHouse);
    }

    @Override
    public void removeWarHouse(Long id) {
        wareHouseRepository.deleteById(id);
    }

    @Override
    public int getTotal() {
        return wareHouseRepository.findAll().size();
    }
}