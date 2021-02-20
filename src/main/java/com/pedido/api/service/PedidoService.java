package com.pedido.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.pedido.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.api.dto.PedidoDTO;
import com.pedido.api.entity.Pedido;
import com.pedido.api.repository.PedidoRepository;

import javax.transaction.Transactional;

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


    public Pedido obterPeloNumeroPedido(Integer numPedido) {

        return repository.findByPedido(numPedido);

    }

    @Transactional
    public Pedido atualizarPedido(Integer numPedido, Pedido pedidoEn) {

        List<Pedido> pedidoList = repository.obterPedido(numPedido);
//        Long qtdePedido = repository.countByPedido(numPedido);

        if(pedidoList.isEmpty()){
            return null;
        }

        pedidoEn.setPedido(numPedido);
        pedidoEn.setId(pedidoList.get(0).getId());

        Pedido pedidoSalvo = repository.save(pedidoEn);

        return pedidoSalvo;



    }
}
