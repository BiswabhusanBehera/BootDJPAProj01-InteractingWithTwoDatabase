package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.repository.offers.IOffersRepository;
import com.nt.repository.prod.IProductRepository;

@Service("productService")
public class ProductMgmtServiceImpl implements IProductMgmtService{

	@Autowired
	private IProductRepository prodRepo;
	@Autowired
	private IOffersRepository offersRepo;
	
	@Override
	public String registerProduct(List<Product> list) {
		prodRepo.saveAll(list);
		return list.size()+"products are saved";
	}

	@Override
	public String registerOffers(List<Offers> list) {
		offersRepo.saveAll(list);
		return list.size()+"offers are saved";
	}

	@Override
	public List<Product> showAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public List<Offers> showAllOffers() {
		return offersRepo.findAll();
	}

}
