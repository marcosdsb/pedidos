package com.pedido.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity(name = "ITEM")
public class Item {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="PEDIDO_ITEM",
	        joinColumns = {@JoinColumn(name="ID_ITEM")},
	        inverseJoinColumns = {@JoinColumn(name="ID_PEDIDO")})
	private List<Pedido> pedidos;
	
	private String descricao;
	
	private Double precoUnitario;
	
	private Integer quantidade;

}
