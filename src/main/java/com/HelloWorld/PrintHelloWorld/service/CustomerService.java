package com.HelloWorld.PrintHelloWorld.service;

import com.HelloWorld.PrintHelloWorld.dao.CustomerDAO;
import com.HelloWorld.PrintHelloWorld.exception.CustomerNotFoundException;
import com.HelloWorld.PrintHelloWorld.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;


    private int customerIdCount=1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    @Transactional
    public Customer addCustomer(Customer customer){
        /*customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;*/

        //return customerDAO.save(customer);
        return customerDAO.save(customer);
        /*return  customer;*/
    }

    @Transactional
    public List<Customer> getCustomers()
    {
        /*return customerList;*/
        return customerDAO.findAll();
    }

    @Transactional
    public Customer getCustomer(int customerId){
        /*return customerList
                .stream()
                .filter(c->c.getCustomerId() == customerId)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);
        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available...");

        return optionalCustomer.get();
        //return customerDAO.findById(customerId);
    }

    @Transactional
    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId);
        /*customerList
                .stream()
                .forEach(c->{
                    if(c.getCustomerId()==customerId){
                        c.setCustFirstName(customer.getCustFirstName());
                        c.setCustLastName(customer.getCustLastName());
                        c.setCustEmail(customer.getCustEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c->c.getCustomerId()==customerId)
                .findFirst()
                .get();*/

        return customerDAO.save(customer);
    }

    @Transactional
    public void deleteCustomer(int customerId){
       /* customerList
                .stream()
                .forEach(c->{
                    if(c.getCustomerId()==customerId)
                        customerList.remove(c);
                });*/
        customerDAO.deleteById(customerId);
    }
}
