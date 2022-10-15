package com.Arris.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Setter @Getter @Column(name = "id_usuario")
    private long idUsuario;
    @Setter @Getter @Column(name = "nombre")
    private String nombre;
    @Setter @Getter @Column(name = "telefono")
    private long telefono;
    @Setter @Getter @Column(name = "email")
    private String email;
    @Setter @Getter @Column(name = "direccion")
    private String direccion;
    @Setter @Getter @Column(name = "contraseña")
    private String contraseña = direccion;

    public Usuario() {
    }

    public Usuario(long idUsuario,String nombre, long telefono, String email, String direccion, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }
}
