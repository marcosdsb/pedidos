package com.pedido.api.controller;

import com.pedido.api.dto.ResponseDTO;
import com.pedido.api.dto.StatusPedidoDTO;
import com.pedido.api.service.StatusPedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/status")
@Api(value = "API STATUS PEDIDO")
@CrossOrigin(origins = "*")
public class StatusPedidoController {

    @Autowired
    private StatusPedidoService service;

    @PostMapping
    @ApiOperation(value = "Muda o STATUS do Pedido")
    public ResponseEntity<ResponseDTO> gravarPedido(@Valid  @RequestBody StatusPedidoDTO statusPedidoDTO, HttpServletResponse response)  {

        ResponseDTO responseDTO = service.validarPedido(statusPedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }


}
