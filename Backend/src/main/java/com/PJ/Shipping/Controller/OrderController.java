package com.PJ.Shipping.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.PJ.Shipping.Entity.Customer;

import com.PJ.Shipping.Entity.Gateway;
import com.PJ.Shipping.Entity.Order;
import com.PJ.Shipping.Entity.Operation;
import com.PJ.Shipping.Repository.CustomerRepository;
import com.PJ.Shipping.Repository.GatewayRepository;
import com.PJ.Shipping.Repository.OrderRepository;
import com.PJ.Shipping.Repository.OperationRepository;


import org.springframework.web.bind.annotation.CrossOrigin;
import javax.persistence.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OrderController {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private GatewayRepository gatewayRepository;
    @Autowired
    private OperationRepository operationRepository;
  


    OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.operationRepository = operationRepository;
        this.customerRepository = customerRepository;
        this.gatewayRepository = gatewayRepository;
    }

    @GetMapping("/Order")
    public Collection<Order> GetOrders() {
        return orderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/findstock")
    public Collection<Order> findstock() {
        return orderRepository.findstock();
    }

    @GetMapping("/findqueue")
    public Collection<Order> findqueue() {
        return orderRepository.findqueue();
    }

    @GetMapping("/findpack")
    public Collection<Order> findpack() {
        return orderRepository.findpack();
    }

    @GetMapping("/gethandover")
    public Collection<Order> gethandover() {
        return orderRepository.gethandover();
    }
    
    @PostMapping("/Order/{Order_name}/{Gateway_id}/{Cus_id}")
    public Order CreateNewOrder(
       
        @PathVariable String Order_name,
        @PathVariable long Gateway_id ,
        @PathVariable long Cus_id 
        ) {

        Order order = new Order();

        Operation Operation = operationRepository.findById(1);
        Customer Customer = customerRepository.findById(Cus_id);
        Gateway Gateways= gatewayRepository.findById(Gateway_id);

       
        
        order.setOrder_name(Order_name);
        order.setGateway(Gateways);
        order.setCustomer(Customer);
        // order.setStatus(1);
        order.setOperation(Operation);
        // newOrder.setCreateOrder_Date(new Date());


        return orderRepository.save(order); // บันทึก Objcet ชื่อ Customer

    }
    @PostMapping("/UpdateOrderToQueue/{Order_id}")
    public Collection<Order> UpdateOrderToQueue(@PathVariable Long Order_id) {
        Operation Operation = operationRepository.findById(2);

        Order order = orderRepository.findById(Order_id).get();
        order.setOperation(Operation);
        orderRepository.save(order);

        
        return orderRepository.findAll().stream().collect(Collectors.toList());
        // return orderRepository.findByOperation(1).stream().collect(Collectors.toList());
    }

    @PostMapping("/UpdateOrderToPack/{Order_id}")
    public Collection<Order> UpdateOrderToPack(@PathVariable Long Order_id) {
        Operation Operation = operationRepository.findById(3);

        Order order = orderRepository.findById(Order_id).get();
        order.setOperation(Operation);
        orderRepository.save(order);

        
        return orderRepository.findAll().stream().collect(Collectors.toList());
       
    }

    @PostMapping("/UpdateOrderToHandover/{Order_id}")
    public Collection<Order> UpdateOrderToHandover(@PathVariable Long Order_id) {
        Operation Operation = operationRepository.findById(4);

        Order order = orderRepository.findById(Order_id).get();
        order.setOperation(Operation);
        orderRepository.save(order);

        
        return orderRepository.findAll().stream().collect(Collectors.toList());
       
    }

}