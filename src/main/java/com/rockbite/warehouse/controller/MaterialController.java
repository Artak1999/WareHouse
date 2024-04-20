package com.rockbite.warehouse.controller;

import com.rockbite.warehouse.model.Material;
import com.rockbite.warehouse.service.impl.MaterialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private MaterialServiceImpl materialServiceImpl;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String materials(Model model){
        model.addAttribute("materials",materialServiceImpl.getAllMaterials());
        return "material";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        materialServiceImpl.delete(id);
    }
}
