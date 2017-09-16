package com.mandar.coffeeshop.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mandar.coffeeshop.domain.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long>{

}
