package com.PJ.Shipping.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import java.util.Collection;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="GATEWAYS")
public class Gateway {
    @Id
    @SequenceGenerator(name="Gateway_seq",sequenceName="Gateway_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Gateway_seq")  
    @Column(name = "Gateway_id", unique = true, nullable = true)
    private Long Gateway_id;
    @Column(name = "Gateway_name")
    private String Gateway_name;


    // @OneToMany(fetch = FetchType.EAGER)
    // // mappedBy  = "Order"
    // private Set<Order> Orders;
}