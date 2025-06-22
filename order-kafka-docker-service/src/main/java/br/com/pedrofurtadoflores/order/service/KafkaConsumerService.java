package br.com.pedrofurtadoflores.order.service;

import br.com.pedrofurtadoflores.common.event.PaymentApprovedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "payment-approved", groupId = "order-group")
    public void consume(PaymentApprovedEvent event) {
        log.info("Received payment approval for order ID {} with status '{}'", event.getOrderId(), event.getStatus());
        // Simulate order status update here
    }
}
