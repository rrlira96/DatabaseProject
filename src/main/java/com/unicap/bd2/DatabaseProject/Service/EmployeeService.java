package com.unicap.bd2.DatabaseProject.Service;

import com.unicap.bd2.DatabaseProject.Entities.Employee;
import com.unicap.bd2.DatabaseProject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
