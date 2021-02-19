package com.pedido.api.controller;


import javax.servlet.http.HttpServletResponse;

import com.pedido.api.entity.Pedido;
import com.pedido.api.mapper.PedidoMapper;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.service.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pedidos")
@Api(value = "API PEDIDO")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private PedidoMapper pedidoMapper;



    @PostMapping
    @ApiOperation(value = "Salva os pedidos com os Itens")
    public ResponseEntity<PedidoDTO> gravarPedido(@RequestBody PedidoDTO pedido, HttpServletResponse response) throws ParseException {

        Pedido pedidoEn = pedidoMapper.convertToEntity(pedido);

        Pedido pedidoSalvo = service.salvarPedido(pedidoEn);

        PedidoDTO pedidoDTO = pedidoMapper.convertToDTO(pedidoSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    

}
