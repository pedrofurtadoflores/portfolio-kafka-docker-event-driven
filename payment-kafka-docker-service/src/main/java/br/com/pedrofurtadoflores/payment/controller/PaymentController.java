package br.com.pedrofurtadoflores.payment.controller;

import br.com.pedrofurtadoflores.common.event.PaymentApprovedEvent;
import br.com.pedrofurtadoflores.payment.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final KafkaProducerService producerService;

    @PostMapping("/{orderId}/approve")
    public String approvePayment(@PathVariable Long orderId) {
        PaymentApprovedEvent event = new PaymentApprovedEvent(orderId, "APPROVED");
        producerService.sendPaymentApprovedEvent(event);
        return "Payment approved and event sent for order ID " + orderId;
    }
}
