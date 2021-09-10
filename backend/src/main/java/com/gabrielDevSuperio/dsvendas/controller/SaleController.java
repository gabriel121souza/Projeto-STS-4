package com.gabrielDevSuperio.dsvendas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielDevSuperio.dsvendas.dto.SaleDTO;
import com.gabrielDevSuperio.dsvendas.dto.SaleSuccessDTO;
import com.gabrielDevSuperio.dsvendas.dto.SalesSumDTO;
import com.gabrielDevSuperio.dsvendas.repositories.SellerRepository;
import com.gabrielDevSuperio.dsvendas.services.SaleService;

@RestController
@RequestMapping(value ="/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<SaleDTO> list = saleService.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller(){
		List<SalesSumDTO> list = saleService.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
		List<SaleSuccessDTO> list = saleService.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
}
