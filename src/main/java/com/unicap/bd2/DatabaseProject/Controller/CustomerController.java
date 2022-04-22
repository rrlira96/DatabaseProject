package com.unicap.bd2.DatabaseProject.Controller;


import com.unicap.bd2.DatabaseProject.Entities.Customer;
import com.unicap.bd2.DatabaseProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return ResponseEntity.ok().body(customer);
        } else {
            return ResponseEntity.badRequest().build();
            // throw new UserAlredyExistsException("Error: Email alredy exist");
        }
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customerBody) {
        Optional<Customer> customer = Optional.ofNullable(customerService.createCustomer(customerBody));
        return customer.isPresent() ? ResponseEntity.ok().body(customer.get()) : ResponseEntity.badRequest().build();    // todo: throw new UserAlredyExistsException("Error: Email alredy exist");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
        return customerService.deleteCustomer(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customerBody) {
        Optional<Customer> customer = Optional.ofNullable(customerService.updateCustomer(id, customerBody));
        return customer.isPresent() ? ResponseEntity.ok().body(customer.get()) : ResponseEntity.notFound().build();    // todo: throw new UserAlredyExistsException("Error: Email alredy exist");
    }

}
