package com.pedido.api.service;

import com.pedido.api.dto.ResponseDTO;
import com.pedido.api.dto.StatusPedidoDTO;
import com.pedido.api.entity.Item;
import com.pedido.api.entity.Pedido;
import com.pedido.api.enums.StatusEnum;
import com.pedido.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class StatusPedidoService {

    @Autowired
    PedidoRepository pedidoRepository;


    public ResponseDTO validarPedido(StatusPedidoDTO statusPedidoDTO) {

        Pedido pedido = pedidoRepository.findByNumPedido(statusPedidoDTO.getPedido());
        ResponseDTO responseDTO = new ResponseDTO();

        Integer totalItensPedido = 0;
        BigDecimal valorTotalPedido = new BigDecimal(0);

        if(pedido == null){
            throw new EmptyResultDataAccessException(1);
        }

        setarStatusPedido(statusPedidoDTO, pedido, responseDTO, totalItensPedido, valorTotalPedido);

        return responseDTO;

    }

    private void setarStatusPedido(StatusPedidoDTO statusPedidoDTO, Pedido pedido, ResponseDTO responseDTO, Integer totalItensPedido, BigDecimal valorTotalPedido) {

        if(statusPedidoDTO.getStatus().equals(StatusEnum.REPROVADO)){
            responseDTO.setStatus(StatusEnum.REPROVADO);
        } else {

            for(Item item : pedido.getItens()){
                totalItensPedido = totalItensPedido + item.getQuantidade();

                BigDecimal qtdeTemp = new BigDecimal(item.getQuantidade());
                BigDecimal valorTotalItem = item.getPrecoUnitario().multiply(qtdeTemp);
                valorTotalPedido = valorTotalPedido.add(valorTotalItem);

            }

            if(totalItensPedido == statusPedidoDTO.getItensAprovados() &&
                    valorTotalPedido.compareTo( statusPedidoDTO.getValorAprovado()) == 0  ){
                responseDTO.setStatus( StatusEnum.APROVADO );
            }

            if(statusPedidoDTO.getItensAprovados().compareTo(totalItensPedido) > 0){
                responseDTO.setStatus( StatusEnum.APROVADO_QTD_A_MAIOR );
            }

            if(statusPedidoDTO.getItensAprovados() < totalItensPedido){
                responseDTO.setStatus( StatusEnum.APROVADO_QTD_A_MENOR );
            }

            if(statusPedidoDTO.getValorAprovado().compareTo(valorTotalPedido) > 0){
                responseDTO.setStatus( StatusEnum.APROVADO_VALOR_A_MAIOR );
            }

            if(statusPedidoDTO.getValorAprovado().compareTo(valorTotalPedido) < 0){
                responseDTO.setStatus( StatusEnum.APROVADO_VALOR_A_MENOR );
            }

        }
    }
}
