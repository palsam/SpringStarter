package com.palani.springmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.palani.springmongo.domain.Sales;

public interface SalesRepository extends MongoRepository<Sales,String>{

}
