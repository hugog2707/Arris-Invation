package com.Arris.service;



import com.Arris.models.RolUsuario;

import java.util.ArrayList;
import java.util.Optional;

public interface RolUsuarioService {
    ArrayList<RolUsuario> getAll();
    Optional<RolUsuario> getById(long idRolUsuario);
    RolUsuario save(RolUsuario r);
    boolean deleteById(long idRolUsuario);
}
