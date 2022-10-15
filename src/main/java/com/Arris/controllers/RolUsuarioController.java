package com.Arris.controllers;


import com.Arris.models.RolUsuario;
import com.Arris.models.Usuario;
import com.Arris.service.RolUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("rolusuario")
public class RolUsuarioController {

    @Autowired
    RolUsuarioService rolUsuarioService;

    @GetMapping("/all")
    public ArrayList<RolUsuario> getAllRolesUsuarios(){
        return rolUsuarioService.getAll();
    }

    @GetMapping("/find/{id}")
    public Optional<RolUsuario> getRolUsuarioById(@PathVariable("id") long idRolUsuario){
        return rolUsuarioService.getById(idRolUsuario);
    }

    @PostMapping("/save")
    public RolUsuario saveRolUsuario(RolUsuario r){
        return rolUsuarioService.save(r);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRolUsuario(@PathVariable("id") long idRolUsuario){
        if (rolUsuarioService.deleteById(idRolUsuario))
            return "se ha eliminado";
        else
            return "no se elimino";
    }


}
