package com.aruizKafka.consumer.service.impl;

import com.aruizKafka.consumer.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerServiceImpl implements ConsumerService {

    /**
     * Escucha el tema "car-sale" en Kafka.
     *
     * @param offer El mensaje recibido del tema de Kafka.
     */
    @KafkaListener(topics = "car-sale")
    @Override
    public void consume(String offer) {
        // Registra el mensaje recibido en el registro
        log.info("Offer -> {}", offer);
    }

}
