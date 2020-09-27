package com.PJ.Shipping.Repository;

import com.PJ.Shipping.Entity.Order;
// import com.PJ.Shipping.Entity.Operation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.data.repository.query.Param;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;


@CrossOrigin(origins = "http://localhost:8080")
@RepositoryRestResource
public
interface OrderRepository extends JpaRepository<Order, Long> {
    Order findById(long Order_id);
    // Order findByOperation(Operation operation);

    @Query(value = "SELECT * FROM ORDERS where OPERATION_ID = 1",
    nativeQuery = true)
    Collection<Order> findstock();


    @Query(value = "SELECT * FROM ORDERS where OPERATION_ID = 2",
    nativeQuery = true)
    Collection<Order> findqueue();

    @Query(value = "SELECT * FROM ORDERS where OPERATION_ID = 3",
    nativeQuery = true)
    Collection<Order> findpack();

    @Query(value = "SELECT * FROM ORDERS where OPERATION_ID = 4",
    nativeQuery = true)
    Collection<Order> gethandover();



}