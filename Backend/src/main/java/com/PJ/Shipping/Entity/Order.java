package com.PJ.Shipping.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
// import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;


import java.util.Collection;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.*; // เพื่อใช้ @NamedQuery

@Data
@Entity

    // @NamedQuery(name ="GetPack",
    //     query ="SELECT * FROM ORDERS WHERE OPERATION_ID = 2")

@NoArgsConstructor
@Table(name="ORDERS")
public class Order {
    @Id
    @SequenceGenerator(name="Order_seq",sequenceName="Order_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Order_seq")  
    @Column(name = "Order_id", unique = true, nullable = true)
    private Long Order_id;

    @Column(name = "Order_name")
    private String Order_name;

    // @Column(name = "status")
    // private int Status;

    // @Column(name="CREATE_DATE")
    // private Date CreateOrder_Date;

    // @OneToMany(fetch = FetchType.EAGER)
    // // mappedBy  = "Room"
    // private Set<Stock> Stocks;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Operation.class)
    @JoinColumn(name = "Operation_id", insertable = true)
    private Operation operation;


    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "CUSTOMER_ID", insertable = true)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gateway.class)
    @JoinColumn(name = "Gateway_id", insertable = true)
    private Gateway Gateway;
}
