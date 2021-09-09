package com.gabrielDevSuperio.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielDevSuperio.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
}
