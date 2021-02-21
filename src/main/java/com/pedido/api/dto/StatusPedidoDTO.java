package com.pedido.api.dto;

import com.pedido.api.enums.StatusEnum;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class StatusPedidoDTO {

    @NotNull
    private String pedido;

    @NotNull
    private StatusEnum status;

    @NotNull
    private Integer itensAprovados;

    @NotNull
    private BigDecimal valorAprovado;

}
