package com.Arris.controllers;


import com.Arris.models.Producto;
import com.Arris.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping("/allq")
    public ArrayList<Producto> getAllProductos(){
        return productoService.getAll();
    }

    @GetMapping("/findq/{id}")
    public Optional<Producto> getProductoById(@PathVariable("id") long idProducto){
        return productoService.getById(idProducto);
    }

    @PostMapping("/saveq")
    public Producto saveProducto(@RequestBody Producto p){
        return productoService.save(p);
    }

    @PostMapping("/insertar_nuevo_producto_admin")
    public String insertarProducto(Producto producto, RedirectAttributes redirectAttrs){
        productoService.save(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Se A Guardado Satisfactioriamente El Nuevo Producto, Numero De Producto#: " + producto.getIdProducto() + ", Categoria: " + producto.getCategoria() + ", Precio: $" + producto.getPrecio()  +  " ✔")
                .addFlashAttribute("clase", "success");
        return "redirect:/administrador_compras_admin";
    }
    @PostMapping("/cambiar_estado_producto")
    public String cambiarEstadoProducto(Producto producto, RedirectAttributes redirectAttrs){
        productoService.save(producto);
        redirectAttrs
                .addFlashAttribute("mensaje", "Se A Guardado Satisfactioriamente El Nuevo Estado Del Producto, Numero De Producto#: " + producto.getIdProducto() + ", Estado Nuevo: " + producto.getEstado() +  " ✔")
                .addFlashAttribute("clase", "success");
        return "redirect:/administrador_compras_admin";
    }

    @DeleteMapping("/deleteq/{id}")
    public String deleteProductoById(@PathVariable("id") long idProducto){
        if (productoService.deleteById(idProducto))
            return "se ha eliminado";
        else
            return "no se elimino";
    }

}
