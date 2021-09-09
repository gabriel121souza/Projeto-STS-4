package com.gabrielDevSuperio.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielDevSuperio.dsvendas.entities.Seller;
public interface SellerRepository  extends JpaRepository<Seller, Long> {

}
