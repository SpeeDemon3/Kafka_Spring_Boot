package com.aruizKafka.producer.service.impl;

import com.aruizKafka.producer.controller.domain.CarOffer;
import com.aruizKafka.producer.service.OfferService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {

    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Envía una oferta de coche al topic "car-sale" utilizando Kafka.
     *
     * @param carOffer La oferta de coche a enviar.
     */
    @Override
    public void makeOffer(CarOffer carOffer) {
        // Registra la información de la oferta en el registro la muestra por consola
        log.info("Sending offer for car id: {}, offer: {}, contact: {}", carOffer.getId(), carOffer.getOffer(), carOffer.getContact());

        // Construye la cadena de la oferta
        String offer = "Offer: Car ID -> " + carOffer.getId() + " Quantity: " + carOffer.getOffer() + " Contact: " + carOffer.getContact();

        // Envía la oferta al topic "car-sale" utilizando KafkaTemplate
        kafkaTemplate.send("car-sale", offer);
    }
}
