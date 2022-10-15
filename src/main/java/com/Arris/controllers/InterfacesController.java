package com.Arris.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class InterfacesController {

    @GetMapping("/interfaz_admin")
    public String interfazAdmin(){
        return "interfaz_administrador/interfaz_administrador";
    }

    @GetMapping("/interfaz_empleado")
    public String interfazEmpleado(){
        return "interfaz_empleado/interfaz_empleado";
    }

    @GetMapping("/interfaz_cliente")
    public String interfazCliente(){
        return "interfaz_cliente/interfaz_cliente";
    }
}
