package com.pedido.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	private Long id;
	
	private Integer pedido;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	@ManyToMany( mappedBy="pedidos",
			cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE})
	@JsonBackReference("pedidos")
	private List<Item> itens;

}
