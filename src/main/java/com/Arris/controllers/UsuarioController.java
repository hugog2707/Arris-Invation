package com.Arris.controllers;

import com.Arris.models.Pedido;
import com.Arris.models.Usuario;
import com.Arris.service.PedidoService;
import com.Arris.service.RolUsuarioService;
import com.Arris.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PedidoService pedidoService;

    @GetMapping("/allw")
    public ArrayList<Usuario> getAllUsuarios(){
        return usuarioService.getAll();
    }

    @GetMapping("/findw/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable("id") long idUsuario){
        return usuarioService.getById(idUsuario);
    }
    @PostMapping("/guardar_nuevo_usuario")
    public String GuardarUsurio(Usuario usuario, Model model, RedirectAttributes redirectAttrs) {
        List<Usuario> usu = usuarioService.getAll();
        usuarioService.save(usuario);
        redirectAttrs
                .addFlashAttribute("mensaje", "Se Registro el Nuevo Usuario Satisfactoriamente, Nombre del Usuario: " + usuario.getNombre() +", Correo Electronico: " + usuario.getEmail() + ", Recuerda que se Envio un Mensaje a Este Correo con La Contraseña ✔")
                .addFlashAttribute("clase", "success");
        model.addAttribute("usuario", usu);
        System.out.println("pedido guardado con exito");
        return "redirect:/gestion_ventas_admin";
    }

    @PostMapping("/savew")
    public Usuario saveUsuario(@RequestBody Usuario u){
        return usuarioService.save(u);
    }

    @DeleteMapping("/deletew/{id}")
    public String deleteUsuario(@PathVariable("id") long idUsuario){
        if (usuarioService.deleteById(idUsuario))
            return "se ha eliminado";
        else
            return "no se elimino";
    }

}
