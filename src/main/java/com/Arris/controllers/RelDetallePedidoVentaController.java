package com.Arris.controllers;


import com.Arris.models.Pedido;
import com.Arris.models.RelDetallePedidoVenta;
import com.Arris.service.RelDetallePedidoVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping
public class RelDetallePedidoVentaController {
    @Autowired
    RelDetallePedidoVentaService relDetallePedidoVentaService;
}
