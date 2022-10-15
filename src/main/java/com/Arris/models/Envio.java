package com.Arris.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "envios")
@ToString
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_envio")
    private long idEnvio;
    @Getter @Setter @Column(name = "fecha_de_entrega")
    private java.sql.Date fechaEntrega;
    @Getter @Setter @Column(name = "estado")
    private String estado;
    @Getter @Setter @ManyToOne @JoinColumn(name = "id_venta")
    private Venta venta;
    @Getter @Setter @Column(name = "empresa")
    private String empresa;

    public Envio() {
    }

    public Envio(java.sql.Date fechaEntrega, String estado, Venta venta, String empresa) {
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.venta = venta;
        this.empresa = empresa;
    }
}
