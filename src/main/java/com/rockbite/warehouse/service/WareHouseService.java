package com.rockbite.warehouse.service;

import com.rockbite.warehouse.model.WareHouse;
import java.util.List;

public interface WareHouseService {
    void addWareHouse(WareHouse wareHouse);
    void removeWarHouse(Long id);
    List<WareHouse> getAll();
    int getTotal();
}
