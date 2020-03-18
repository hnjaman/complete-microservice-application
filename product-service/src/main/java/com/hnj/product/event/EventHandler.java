package com.hnj.product.event;

import com.hnj.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * This class receives the events and triggers the associated
 * business logic.
 */
@Slf4j
@Component
class EventHandler {

    private ProductService productService;

    EventHandler(final ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = "${offer.queue}")
    void handleOfferEvent(final ProductOfferEvent productOfferEvent) {
        log.info("Offer productOfferEvent received for the product of: {}", productOfferEvent.getProductId());
        try {
            if (productOfferEvent.getDiscountOffer() > 0)
                productService.addProductOffer(productOfferEvent.getProductId(), productOfferEvent.getDiscountOffer());
        } catch (final Exception e) {
            log.error("Error when trying to add offer", e);
            // Avoids the productOfferEvent to be re-queued and reprocessed.
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
