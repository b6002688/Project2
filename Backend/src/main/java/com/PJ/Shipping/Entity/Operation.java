package com.PJ.Shipping.Entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
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

@Data
@Entity
@NoArgsConstructor
@Table(name="OPERATIONS")
public class Operation {
    @Id
    @SequenceGenerator(name="Operation_seq",sequenceName="Operation_seq")               
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Operation_seq")  
    @Column(name = "Operation_id", unique = true, nullable = true)
    private Long Operation_id;
    
    @Column(name = "Operation_name")
    private String Operation_name;

  
    // @Column(name="CREATEOPER_DATE")
    // private Date Oper_Date;

    // @OneToMany(fetch = FetchType.EAGER)
    // // mappedBy  = "Room"
    // private Set<Stock> Stocks;
    
}
