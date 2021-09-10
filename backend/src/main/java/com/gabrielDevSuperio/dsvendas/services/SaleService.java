package com.gabrielDevSuperio.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gabrielDevSuperio.dsvendas.dto.SaleDTO;
import com.gabrielDevSuperio.dsvendas.entities.Sale;
import com.gabrielDevSuperio.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository saleRepository;
	
	
	public Page<SaleDTO> findAll(Pageable pageable){
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
}
