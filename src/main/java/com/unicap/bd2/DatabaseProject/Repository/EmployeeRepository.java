package com.unicap.bd2.DatabaseProject.Repository;

import com.unicap.bd2.DatabaseProject.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
