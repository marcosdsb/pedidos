package com.pedido.api.mapper;

import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.entity.Pedido;
import com.pedido.api.service.PedidoService;
import org.apache.tomcat.util.json.ParseException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoMapper {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PedidoService service;

    public Pedido convertToEntity(PedidoDTO pedidoDTO) throws ParseException {

        Pedido pedido = modelMapper.map(pedidoDTO, Pedido.class);

        if(pedidoDTO.getId() != null){
            Optional<Pedido> pedidoAnterior = service.buscarPorId(pedidoDTO.getId());
            pedido.setId(pedidoAnterior.get().getId());
        }

        return pedido;

    }

    public PedidoDTO convertToDTO(Pedido pedido) throws ParseException {

        PedidoDTO pedidoDTO = modelMapper.map(pedido, PedidoDTO.class);

        return pedidoDTO;

    }



}
