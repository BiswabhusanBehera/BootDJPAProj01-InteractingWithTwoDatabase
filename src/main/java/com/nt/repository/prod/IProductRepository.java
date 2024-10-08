package com.nt.repository.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.prod.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
