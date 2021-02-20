package com.pedido.api.service;

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
        return repository.findById(id);
    }


    public Pedido salvarPedido(Pedido pedido){
        Pedido pedidoSalvo = repository.save(pedido);
        return pedidoSalvo;

    }


    public Pedido obterPeloNumeroPedido(Integer numPedido) {

        Pedido pedido = repository.findByNumPedido(numPedido);
        return pedido;

    }

    @Transactional
    public Pedido atualizarPedido(Integer numPedido, Pedido pedidoEn) {

        Pedido pedido = repository.findByNumPedido(numPedido);

        if(pedido == null){
            return null;
        }

        pedidoEn.setNumPedido(numPedido);
        pedidoEn.setId(pedido.getId());

        repository.delete(pedido);

        Pedido pedidoSalvo = repository.save(pedidoEn);

        return pedidoSalvo;

    }

    public void deletarPedido(Integer numPedido) {

        Pedido pedido = repository.findByNumPedido(numPedido);
        repository.delete(pedido);

    }
}
