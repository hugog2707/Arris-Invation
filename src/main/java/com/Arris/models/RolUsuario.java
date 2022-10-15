package com.Arris.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles_usuarios")
@ToString
public class RolUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter @Column(name = "id_rol_usuario")
    private long idRolUsuario;

    @Setter @Getter
    @ManyToOne @JoinColumn(name = "id_rol")
    private Rol rol;

    @Setter @Getter
    @ManyToOne @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public RolUsuario() {
    }

    public RolUsuario(Rol rol, Usuario usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }
}
