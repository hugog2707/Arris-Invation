package com.Arris.service;


import com.Arris.models.Usuario;

import java.util.ArrayList;
import java.util.Optional;

public interface UsuarioService {
    ArrayList<Usuario> getAll();
    Optional<Usuario> getById(long idUsuario);
    Usuario save(Usuario u);
    boolean deleteById(long idUsuario);
}
