package br.com.pedrofurtadoflores.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApprovedEvent {
    private Long orderId;
    private String status;
}
