package com.hnj.offer.controller;

import com.hnj.offer.model.Offer;
import com.hnj.offer.model.request.OfferRequest;
import com.hnj.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000", allowedHeaders="*")
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

	@GetMapping("/offer")
	public List<Offer> getOffers(){
		return offerService.getOffers();
	}
}
