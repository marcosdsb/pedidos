package com.pedido.api.dto;

import com.pedido.api.enums.StatusEnum;
import lombok.*;

@Data
@Builder
@AllArgsConstructor(access =  AccessLevel.PACKAGE)
@NoArgsConstructor
public class ResponseDTO {

    private StatusEnum status;

}
