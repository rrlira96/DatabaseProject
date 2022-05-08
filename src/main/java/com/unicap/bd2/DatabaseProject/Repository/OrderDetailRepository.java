package com.unicap.bd2.DatabaseProject.Repository;

import com.unicap.bd2.DatabaseProject.Entities.OrderDetail;
import com.unicap.bd2.DatabaseProject.Entities.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailPK> {
}
