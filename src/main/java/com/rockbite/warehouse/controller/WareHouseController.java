package com.rockbite.warehouse.controller;

import com.rockbite.warehouse.model.WareHouse;
import com.rockbite.warehouse.service.impl.WareHouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/warehouse")
public class WareHouseController {

    @Autowired
    private WareHouseServiceImpl wareHouseServiceImpl;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String warehouse(Model model){
        model.addAttribute("warehouse",wareHouseServiceImpl.getAll());
        return "warehouse";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody WareHouse wareHouse){
        wareHouseServiceImpl.addWareHouse(wareHouse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        wareHouseServiceImpl.removeWarHouse(id);
    }

}