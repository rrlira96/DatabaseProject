package com.unicap.bd2.DatabaseProject.Controller;


import com.unicap.bd2.DatabaseProject.Entities.Product;
import com.unicap.bd2.DatabaseProject.Entities.ProductWithDiscount;
import com.unicap.bd2.DatabaseProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PostMapping("/discount")
    @Transactional(readOnly = true)
    public ResponseEntity<Double> getProductWithDiscount(@RequestBody ProductWithDiscount productWithDiscount) {
        return ResponseEntity.ok().body(productService.getProductWithDiscount(productWithDiscount));
    }


}
