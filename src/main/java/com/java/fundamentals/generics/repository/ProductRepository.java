package com.java.fundamentals.generics.repository;

import com.java.fundamentals.generics.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product,Long>{
}
