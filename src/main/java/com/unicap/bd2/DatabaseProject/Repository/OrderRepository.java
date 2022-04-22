package com.unicap.bd2.DatabaseProject.Repository;

import com.unicap.bd2.DatabaseProject.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
