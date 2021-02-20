package com.pedido.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedido.api.entity.Pedido;
import com.pedido.api.repository.PedidoRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Optional<Pedido> buscarPorId(long id){

//        return repository.findById(id);
        return null;

    }


    public Pedido salvarPedido(Pedido pedido){

//		pedido.getItens().forEach(item ->{
//			item.setPedidos(new ArrayList<>());
//			item.getPedidos().add(pedido);
//		});
//
//        return repository.save(pedido);

        return null;

    }


    public Pedido obterPeloNumeroPedido(Integer numPedido) {


        return null;

    }

    @Transactional
    public Pedido atualizarPedido(Integer numPedido, Pedido pedidoEn) {

//        List<Pedido> pedidoList = repository.findByPedido(numPedido);
//
//        if(pedidoList.isEmpty()){
//            return null;
//        }
//
//        pedidoEn.setPedido(numPedido);
//        pedidoEn.setId(pedidoList.get(0).getId());
//
//        repository.deleteAll(pedidoList);
//
//        Pedido pedidoSalvo = repository.save(pedidoEn);
//
//        return pedidoSalvo;

        return null;

    }
}
