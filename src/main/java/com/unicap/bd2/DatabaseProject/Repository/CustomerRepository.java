package com.unicap.bd2.DatabaseProject.Repository;

import com.unicap.bd2.DatabaseProject.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
