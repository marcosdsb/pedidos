package com.pedido.api.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.entity.Pedido;
import com.pedido.api.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Optional<Pedido> buscarPorId(long id){

        return repository.findById(id);

    }


    public Pedido salvarPedido(Pedido pedido){

		pedido.getItens().forEach(item ->{
			item.setPedidos(new ArrayList<>());
			item.getPedidos().add(pedido);
		});

        return repository.save(pedido);

    }




}
