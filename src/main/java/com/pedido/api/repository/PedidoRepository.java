package com.pedido.api.repository;

import com.pedido.api.entity.Pedido;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public Pedido findByPedido(Integer numPedido);

    Long countByPedido(Integer numPedido);


    @Query(value = "FROM PEDIDO pedido "
            +"JOIN FETCH pedido.itens itens "
            +"WHERE pedido.pedido=:numPedido")
    List<Pedido> obterPedido(@Param("numPedido") Integer numPedido);

}
