package com.example.springreactiver2dbc.repository;

import com.example.springreactiver2dbc.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}
