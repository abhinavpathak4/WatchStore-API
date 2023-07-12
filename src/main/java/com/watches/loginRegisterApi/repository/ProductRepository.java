package com.watches.loginRegisterApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watches.loginRegisterApi.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

}
