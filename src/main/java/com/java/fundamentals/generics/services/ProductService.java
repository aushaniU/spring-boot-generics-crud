package com.java.fundamentals.generics.services;

import com.java.fundamentals.generics.dto.ProductDTO;
import com.java.fundamentals.generics.entity.Product;
import com.java.fundamentals.generics.repository.BaseRepository;
import com.java.fundamentals.generics.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product, ProductDTO,Long>{


    public ProductService(ModelMapper modelMapper, BaseRepository<Product, Long> repository) {
        super(modelMapper, repository, Product.class, ProductDTO.class);
    }
}
