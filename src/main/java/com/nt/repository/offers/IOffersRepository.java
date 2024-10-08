package com.nt.repository.offers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.offers.Offers;

public interface IOffersRepository extends JpaRepository<Offers, Integer> {

}
