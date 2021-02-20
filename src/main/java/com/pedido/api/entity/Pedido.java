package com.pedido.api.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pedido.api.enums.StatusEnum;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity(name = "PEDIDO")
public class Pedido {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name= "ID")
	private Long id;

	@Column(name = "NUM_PEDIDO")
	private Integer pedido;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private StatusEnum status;
	
//	@ManyToMany( mappedBy="pedidos",
//			cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
//	@JsonBackReference("pedidos")
//	private List<Item> itens;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
	@JsonBackReference("pedidos")
	private Item item;


}
