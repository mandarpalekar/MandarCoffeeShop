package com.mandar.coffeeshop.domain;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Long idp;

    private String name;

    private BigDecimal price;

	public Long getIdp() {
		return idp;
	}

	public void setIdp(Long idp) {
		this.idp = idp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

