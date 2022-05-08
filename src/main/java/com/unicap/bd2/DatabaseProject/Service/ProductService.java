package com.unicap.bd2.DatabaseProject.Service;

import com.unicap.bd2.DatabaseProject.Entities.Product;
import com.unicap.bd2.DatabaseProject.Entities.ProductWithDiscount;
import com.unicap.bd2.DatabaseProject.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Double getProductWithDiscount(ProductWithDiscount productWithDiscount) {
        return productRepository.getProductWithDiscount(productWithDiscount.getProductId(), productWithDiscount.getDiscount());
    }
}
