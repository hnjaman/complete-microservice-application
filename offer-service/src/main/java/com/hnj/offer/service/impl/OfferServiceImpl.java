package com.hnj.offer.service.impl;

import com.hnj.offer.event.EventDispatcher;
import com.hnj.offer.event.ProductOfferEvent;
import com.hnj.offer.model.Offer;
import com.hnj.offer.model.request.OfferRequest;
import com.hnj.offer.repository.OfferRepository;
import com.hnj.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OfferServiceImpl implements OfferService {

	private final OfferRepository offerRepository;
	private EventDispatcher eventDispatcher;

	@Autowired
	public OfferServiceImpl(OfferRepository offerRepository,
							EventDispatcher eventDispatcher) {
		this.offerRepository = offerRepository;
		this.eventDispatcher = eventDispatcher;
	}

	@Transactional
	@Override
	public void addProductOffer(OfferRequest offerRequest) {
		Offer offer = new Offer().builder()
				.productId(offerRequest.getProductId())
				.discountOffer(offerRequest.getDiscountOffer())
				.build();

		offerRepository.save(offer);
		eventDispatcher.send(new ProductOfferEvent(offer.getProductId(), offer.getDiscountOffer()));
	}
}
