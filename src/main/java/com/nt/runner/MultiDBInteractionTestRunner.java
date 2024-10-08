package com.nt.runner;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.service.IProductMgmtService;

@Component
public class MultiDBInteractionTestRunner implements CommandLineRunner {

	@Autowired
	private IProductMgmtService prodService;
	
	@Override
	public void run(String... args) throws Exception {
/*	// save product
		List<Product> productList = List.of(new Product("table",90000.0,10.0,true,LocalDateTime.of(2018,10,20,12,11,33)),
																	  new Product("chair",40000.0,10.0,true,LocalDateTime.of(2018,10,22,12,11,43)));
		prodService.registerProduct(productList);
		System.out.println("-----------------------------------------------");
		
		//save offers
		List<Offers> offersList = List.of(new Offers("MoonSoonOffers",40.0f,LocalDateTime.now(),LocalDateTime.of(2024,10,20,12,11,33)),
															  new Offers("GreatIndianSales",40.0f,LocalDateTime.now(),LocalDateTime.of(2024,9,20,12,11,33)));
		prodService.registerOffers(offersList);
	*/
		
		prodService.showAllProducts().forEach(System.out::println);
		System.out.println("-----------------------------------------------");
		prodService.showAllOffers().forEach(System.out::println);
	}

}
