package com.pedido.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	
	private Long id;
	private Integer numPedido;
	private String status;
	private List<ItemDTO> itens;

}
