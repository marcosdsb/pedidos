package com.pedido.api.repository;

import com.pedido.api.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public Pedido findByNumPedido(Integer numPedido);

}
