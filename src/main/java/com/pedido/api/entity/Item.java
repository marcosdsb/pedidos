package com.pedido.api.entity;

import java.util.List;

import javax.persistence.*;

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
	@Column(name = "ID")
	private Long id;

//	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
//	@JoinTable(name="PEDIDO_ITEM",
//	        joinColumns = {@JoinColumn(name="ID_ITEM")},
//	        inverseJoinColumns = {@JoinColumn(name="ID_PEDIDO")})
//	private List<Pedido> pedidos;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "NUM_PEDIDO")
	private List<Pedido> numPedidos;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PRECO_UNITARIO")
	private Double precoUnitario;

	@Column(name = "QUANTIDADE")
	private Integer quantidade;

}
