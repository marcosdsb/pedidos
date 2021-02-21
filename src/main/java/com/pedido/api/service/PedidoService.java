package com.pedido.api.service;

import java.util.List;
import java.util.Optional;

import com.pedido.api.entity.Item;
import com.pedido.api.exceptionHandler.capturarExceptions.ItensNaoInformadosException;
import com.pedido.api.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Transactional
    public Pedido salvarPedido(Pedido pedido){

        validarItens(pedido.getItens());

        Pedido pedidoSalvo = repository.save(pedido);
        return pedidoSalvo;

    }

    public Pedido obterPeloNumeroPedido(String numPedido) {

        Pedido pedido = repository.findByNumPedido(numPedido);

        if(pedido == null){
            throw new EmptyResultDataAccessException(1);
        }

        return pedido;

    }

    @Transactional
    public Pedido atualizarPedido(String numPedido, Pedido pedidoEn) {

        validarItens(pedidoEn.getItens());

        Pedido pedido = repository.findByNumPedido(numPedido);

        if(pedido == null){
            throw new EmptyResultDataAccessException(1);
        }

        pedidoEn.setNumPedido(numPedido);
        pedidoEn.setId(pedido.getId());

        repository.delete(pedido);

        Pedido pedidoSalvo = repository.save(pedidoEn);

        return pedidoSalvo;

    }

    @Transactional
    public void deletarPedido(String numPedido) {

        Pedido pedido = repository.findByNumPedido(numPedido);

        if(pedido == null){
            throw new EmptyResultDataAccessException(1);
        }

        repository.delete(pedido);

    }

    private void validarItens(List<Item> itens) {
        String erros = null;
        boolean verDescricao = false;
        boolean verPrecoUnit = false;
        boolean verQtde = false;

        for(Item item : itens ){

            if( (item.getDescricao() == null || StringUtils.isEmpty(item.getDescricao())) && !verDescricao){
                if(erros != null){
                    erros = erros+", "+ Constants.DESCRICAO;
                } else {
                    erros = Constants.DESCRICAO;;
                }
                verDescricao = true;
            }

            if(item.getPrecoUnitario() == null && !verPrecoUnit ){
                if (erros != null) {
                    erros = erros+", " + Constants.PRECO_UNITARIO;
                } else {
                    erros = Constants.PRECO_UNITARIO;
                }
                verPrecoUnit = true;
            }

            if( (item.getQuantidade() == null || item.getQuantidade() == 0) && !verQtde )  {
                if (erros != null) {
                    erros = erros+", " + Constants.QUANTIDADE;
                } else {
                    erros =  Constants.QUANTIDADE;
                }
                verQtde = true;

            }

        }

        if(erros != null){
            throw new ItensNaoInformadosException(erros);
        }

    }
}
