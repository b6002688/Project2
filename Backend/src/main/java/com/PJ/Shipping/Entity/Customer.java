package com.PJ.Shipping.Entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.PJ.Shipping.Entity.Order;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Data
@Entity
@NoArgsConstructor
@Table(name="CUSTOMER" ,uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Customer_Email"}) })
public class Customer {
	@Id
	@SequenceGenerator(name="customer_seq",sequenceName="customer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_seq")
	@Column(name="Cus_id",unique = true, nullable = true)
    private @NonNull Long Cus_id;

    @NotNull
    @Column(name="Customer_fname")
    private String Fname;

    @NotNull
    @Column(name="Customer_lname")
    private String Lname;

    @NotNull
    @Email
    @Column(name="Customer_Email",unique = true)
    private String Email;

    @Pattern(regexp = "\\d{10}")
    @Column(name="Customer_Phone")
    private String Phone;

    // @OneToMany(fetch = FetchType.EAGER)
    // // mappedBy  = "Order"
    // private Set<Order> Orders;
	}
