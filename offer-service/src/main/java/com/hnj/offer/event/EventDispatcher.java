package com.hnj.offer.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Handles the communication with the Event Bus.
 */
@Component
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;

    // The exchange to use to send anything related to offer
    private String offerExchange;

    // The routing key to use to send this particular event
    private String offerSolvedRoutingKey;

    @Autowired
    EventDispatcher(final RabbitTemplate rabbitTemplate,
                    @Value("${offer.exchange}") final String offerExchange,
                    @Value("${offer.pushed.key}") final String offerSolvedRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.offerExchange = offerExchange;
        this.offerSolvedRoutingKey = offerSolvedRoutingKey;
    }

    public void send(final ProductOfferEvent productOfferEvent) {
        rabbitTemplate.convertAndSend(
                offerExchange,
                offerSolvedRoutingKey,
                productOfferEvent);
    }
}
