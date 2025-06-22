package br.com.pedrofurtadoflores.payment.service;

import br.com.pedrofurtadoflores.common.event.PaymentApprovedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, PaymentApprovedEvent> kafkaTemplate;

    public void sendPaymentApprovedEvent(PaymentApprovedEvent event) {
        kafkaTemplate.send("payment-approved", event);
    }
}
