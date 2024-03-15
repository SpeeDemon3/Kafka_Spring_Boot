package com.aruizKafka.producer.controller;

import com.aruizKafka.producer.controller.domain.CarOffer;
import com.aruizKafka.producer.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarOfferController {

    private final OfferService offerService;

    /**
     * Método para recibir una oferta de coche y enviarla al servicio de ofertas para su procesamiento.
     *
     * @param carOffer La oferta de coche recibida en el cuerpo de la solicitud.
     * @return ResponseEntity con el mensaje indicando que la oferta se envió correctamente.
     */
    @PostMapping("/offer")
    ResponseEntity<?> makeOffer(@RequestBody CarOffer carOffer) {
        // Llama al método makeOffer del servicio de ofertas para enviar la oferta
        offerService.makeOffer(carOffer);
        // Devuelve una respuesta HTTP 200 OK
        return ResponseEntity.ok("the offer was sent correctly.");
    }

}
