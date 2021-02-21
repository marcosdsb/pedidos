package com.pedido.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
	
	private Long id;

	@NotNull
	private String numPedido;

	@NotNull
	private List<ItemDTO> itens;

}
