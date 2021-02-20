package com.pedido.api.controller;


import javax.servlet.http.HttpServletResponse;

import com.pedido.api.entity.Pedido;
import com.pedido.api.mapper.PedidoMapper;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.service.PedidoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/pedido")
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

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
    }

    @GetMapping("/{numPedido}")
    @ApiOperation(value = "Obter dados pelo número do pedido")
    public ResponseEntity<PedidoDTO> ObterPeloNumeroPedido(@PathVariable Integer numPedido) throws ParseException {
        Pedido pedido = service.obterPeloNumeroPedido(numPedido);
        return pedido != null ? ResponseEntity.ok(pedidoMapper.convertToDTO(pedido)) : ResponseEntity.noContent().build();
    }

    @PutMapping("/{numPedido}")
    @ApiOperation(value = "Atualiza um pedido existente pelo número do pedido")
    public ResponseEntity<PedidoDTO> atualizarCategoria(@PathVariable Integer numPedido, @RequestBody PedidoDTO pedidoDTO) {

        Pedido pedidoEn = null;
        PedidoDTO dto = null;
        Pedido pedidoAtualizado = null;

        try{
            pedidoEn = pedidoMapper.convertToEntity(pedidoDTO);
            pedidoAtualizado = service.atualizarPedido(numPedido, pedidoEn);

            if (pedidoAtualizado != null){
                dto = pedidoMapper.convertToDTO(pedidoAtualizado);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }


        return pedidoAtualizado != null ? ResponseEntity.ok(dto) : ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{numPedido}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta Pedido pelo número do Pedido")
    public void deletarPedido(@PathVariable Integer numPedido) {
        service.deletarPedido(numPedido);
    }

    

}
