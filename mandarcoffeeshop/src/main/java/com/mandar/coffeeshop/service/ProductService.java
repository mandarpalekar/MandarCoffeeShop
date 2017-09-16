/**
 * 
 */
package com.mandar.coffeeshop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mandar.coffeeshop.domain.Product;

@Repository
public interface ProductService extends JpaRepository<Product, Long>{

}
