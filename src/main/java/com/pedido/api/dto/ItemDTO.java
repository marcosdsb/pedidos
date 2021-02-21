package com.pedido.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class ItemDTO {
	
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String descricao;

	@NotNull
	private BigDecimal precoUnitario;

	@NotNull
	private Integer quantidade;

}
