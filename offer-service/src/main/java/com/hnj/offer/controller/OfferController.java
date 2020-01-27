package com.hnj.offer.controller;

import com.hnj.offer.model.request.OfferRequest;
import com.hnj.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OfferController {
	private OfferService offerService;

	@Autowired
	public OfferController(OfferService offerService){
		this.offerService = offerService;
	}

	@PostMapping("/offer")
	public void addProductOffer(@Valid @RequestBody OfferRequest offerRequest){
		offerService.addProductOffer(offerRequest);
	}
}
