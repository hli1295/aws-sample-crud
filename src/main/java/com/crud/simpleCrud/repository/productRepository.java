package com.crud.simpleCrud.repository;

import com.crud.simpleCrud.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product,Integer> {


    product findByName(String name);
}
