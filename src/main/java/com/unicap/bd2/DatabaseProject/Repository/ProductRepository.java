package com.unicap.bd2.DatabaseProject.Repository;

import com.unicap.bd2.DatabaseProject.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional
    @Procedure(procedureName = "APPLY_DISCOUNT", outputParameterName = "productDiscounted")
    Double getProductWithDiscount(@Param("productId") Integer productId, @Param("discount") Double discount);

}
