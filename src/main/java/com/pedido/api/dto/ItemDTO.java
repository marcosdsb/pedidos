package com.pedido.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class ItemDTO {
	
	private Long id;
	
//	private Long pedido;
	
	private String descricao;
	
	private Double precoUnitario;
	
	private Integer quantidade;

}
