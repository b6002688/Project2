package com.PJ.Shipping.Repository;

import com.PJ.Shipping.Entity.Customer;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
public
interface CustomerRepository extends JpaRepository<Customer, Long> { 
    Customer findById(long id); 
    
}