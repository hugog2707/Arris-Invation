package com.Arris.service;


import com.Arris.models.Usuario;
import com.Arris.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ArrayList<Usuario> getAll() {
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> getById(long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @Override
    public Usuario save(Usuario u) {
        return usuarioRepository.save(u);
    }

    @Override
    public boolean deleteById(long idUsuario) {
        try {
            Optional<Usuario> u = getById(idUsuario);
            usuarioRepository.delete(u.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
