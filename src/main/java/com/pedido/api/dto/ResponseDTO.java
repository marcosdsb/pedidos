package com.pedido.api.dto;

import com.pedido.api.enums.StatusEnum;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor(access =  AccessLevel.PACKAGE)
@NoArgsConstructor
public class ResponseDTO {

    private List<StatusEnum> status;

}
