package com.unicap.bd2.DatabaseProject.Service;

import com.unicap.bd2.DatabaseProject.Entities.Customer;
import com.unicap.bd2.DatabaseProject.Repository.CustomerRepository;
import com.unicap.bd2.DatabaseProject.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(String id) {
        Optional<Customer> customer =  customerRepository.findById(id);
        return customer.orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public Customer createCustomer (Customer customer) {
        if(!customerRepository.existsById(customer.getCustomerId())) {
           return customerRepository.save(customer);
        }
        return null;
    }

    public boolean deleteCustomer(String id) {
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    public Customer updateCustomer(String id, Customer obj) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.isPresent() ? updateData(customer.get(), obj) : null;
    }

    public Customer updateData(Customer customer, Customer obj) {
        customer.setAddress(obj.getAddress());
        customer.setCity(obj.getCity());
        customer.setCompanyName(obj.getCompanyName());
        customer.setContactName(obj.getContactName());
        customer.setCountry(obj.getCountry());
        customer.setContactTitle(obj.getContactTitle());
        customer.setFax(obj.getFax());
        customer.setPhone(obj.getPhone());
        customer.setPostalCode(obj.getPostalCode());
        customer.setRegion(obj.getRegion());
        return customerRepository.save(customer);
    }

}
