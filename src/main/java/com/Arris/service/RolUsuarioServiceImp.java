package com.Arris.service;


import com.Arris.models.RolUsuario;
import com.Arris.repository.RolUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RolUsuarioServiceImp implements RolUsuarioService{

    @Autowired
    RolUsuarioRepository usuarioRepository;


    @Override
    public ArrayList<RolUsuario> getAll() {
        return (ArrayList<RolUsuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<RolUsuario> getById(long idRolUsuario) {
        return usuarioRepository.findById(idRolUsuario);
    }

    @Override
    public RolUsuario save(RolUsuario r) {
        return usuarioRepository.save(r);
    }

    @Override
    public boolean deleteById(long idRolUsuario) {
        try {
            Optional<RolUsuario> r = getById(idRolUsuario);
            usuarioRepository.delete(r.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
