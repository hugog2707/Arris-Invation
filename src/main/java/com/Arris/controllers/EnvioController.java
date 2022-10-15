package com.Arris.controllers;

import com.Arris.models.Envio;
import com.Arris.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EnvioController {

    @Autowired
    EnvioService envioService;

    @GetMapping("/allqq")
    public ArrayList<Envio> getAllEnvios(){
        return envioService.getAll();
    }

    @GetMapping("/verificacion_envios_admin")
    public String listarEnvio(Model model){
        List<Envio> envio = envioService.getAll();
        model.addAttribute("envio", envio);
        return "interfaz_administrador/templates/verificacion_envios";
    }

    @GetMapping("/verificacion_envios_empleado")
    public String listarEnvioEmpleado(Model model){
        List<Envio> envio = envioService.getAll();
        model.addAttribute("envio", envio);
        return "interfaz_empleado/templates/envios";
    }

    @GetMapping("/findqq/{id}")
    public Optional<Envio> getEnvioById(@PathVariable("id") long idEnvio){
        return envioService.getById(idEnvio);
    }

    @PostMapping("/saveqq")
    public Envio saveEnvio(@RequestBody Envio e){
        return envioService.save(e);
    }

    @PostMapping("/editar_envio_admin")
        public String editarEnvio(Envio envio, RedirectAttributes redirectAttrs){
        envioService.save(envio);
        redirectAttrs
                .addFlashAttribute("mensaje", "Se a editado satisfactoriamente el envio, Numero De Envio: #" + envio.getIdEnvio() +", Estado: " + envio.getEstado() + ", Empresa Envio: " + envio.getEmpresa() + " ✔")
                .addFlashAttribute("clase", "success");
        return "redirect:/verificacion_envios_admin";
    }

    @DeleteMapping("/deleteqq/{id}")
    public String deleteEnvioById(@PathVariable("id") long idEnvio){
        if (envioService.deleteById(idEnvio))
            return "se ha eliminado";
        else
            return "no se elimino";
    }


}
