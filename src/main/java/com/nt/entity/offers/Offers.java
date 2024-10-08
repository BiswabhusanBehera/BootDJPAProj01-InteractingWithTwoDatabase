package com.nt.entity.offers;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "JPA_MYSQL_OFFERS_TAB")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Offers  implements Serializable{

	public Offers(String string, float f, LocalDateTime now, LocalDateTime of) {
		System.out.println("0-param constructor");
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;
	@Column(length = 30)
	private String offerName;
	@NonNull
	private Float discountPercentage;
	@NonNull
	private LocalDateTime startFrom;
	@NonNull
	private LocalDateTime endsOn;
}
