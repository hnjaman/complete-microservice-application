package com.hnj.offer.service;

import com.hnj.offer.model.Offer;
import com.hnj.offer.model.request.OfferRequest;

import java.util.List;

public interface OfferService {
    void addProductOffer(OfferRequest offerRequest);

    List<Offer> getOffers();
}
