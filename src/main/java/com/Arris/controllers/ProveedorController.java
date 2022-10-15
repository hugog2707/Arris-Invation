package com.Arris.controllers;

import com.Arris.models.Proveedor;
import com.Arris.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/all")
    public ArrayList<Proveedor> getAllProveedores(){
        return proveedorService.getAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Proveedor> getProveedorById(@PathVariable("id") long idProveedor){
        return proveedorService.getById(idProveedor);
    }

    @PostMapping("/save")
    public Proveedor saveProveedor(@RequestBody Proveedor p){
        return proveedorService.save(p);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProveedor(@PathVariable("id") long idProveedor){
        if (proveedorService.deleteById(idProveedor))
            return "se ha eliminado";
        else
            return "no se elimino";
    }

}
