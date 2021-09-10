package com.gabrielDevSuperio.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gabrielDevSuperio.dsvendas.dto.SaleSuccessDTO;
import com.gabrielDevSuperio.dsvendas.dto.SalesSumDTO;
import com.gabrielDevSuperio.dsvendas.entities.Sale;
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.gabrielDevSuperio.dsvendas.dto.SalesSumDTO(obj.seller, SUM(obj.amount))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SalesSumDTO> amountGroupedBySeller();

	@Query("SELECT new  com.gabrielDevSuperio.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
