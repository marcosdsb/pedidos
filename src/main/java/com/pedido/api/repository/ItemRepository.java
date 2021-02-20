package com.pedido.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedido.api.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


	

}
