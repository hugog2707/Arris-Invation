package com.Arris.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pqrs",  schema = "lipems")
@ToString
public class Pqrs {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_pqrs")
    private long idPqrs;
    @Getter @Setter @Column(name = "tipo_pqrs")
    private String tipoPqrs;
    @Getter @Setter @Column(name = "descripcion_pqrs")
    private String descripcionPqrs;
    @Getter @Setter @Column(name = "estado_pqrs")
    private String estadoPqrs;
    @Getter @Setter @Column(name = "fecha")
    private java.sql.Date fecha;
    @Getter @Setter @ManyToOne @JoinColumn(name = "id_venta")
    private Venta venta;
    @Getter @Setter @Column(name = "respuesta")
    private String respuesta;

    public Pqrs() {
    }

    public Pqrs(String tipoPqrs, String descripcionPqrs, String estadoPqrs, java.sql.Date fecha, Venta venta, String respuesta) {
        this.tipoPqrs = tipoPqrs;
        this.descripcionPqrs = descripcionPqrs;
        this.estadoPqrs = estadoPqrs;
        this.fecha = fecha;
        this.venta = venta;
        this.respuesta = respuesta;
    }
}
