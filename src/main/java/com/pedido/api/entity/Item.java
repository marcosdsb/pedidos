package com.pedido.api.entity;

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

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PRECO_UNITARIO")
	private Double precoUnitario;

	@Column(name = "QUANTIDADE")
	private Integer quantidade;

}
