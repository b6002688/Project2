package com.SE.RoomBook;

import com.SE.RoomBook.Entity.Order;
import com.SE.RoomBook.Repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class OrderTest{
    private Validator validator;
        
    @Autowired
    private OrderRepository orderRepository;
    
    @BeforeEach
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //Test ข้อมูลครบถูกต้อง
    @Test
    void testOrderOKFullData(){
        Order order = new Order();
        order.setOrder_name("Test");
        

        order = orderRepository.saveAndFlush(order);
        Optional<Order> found = orderRepository.findById(order.getId());
        assertEquals("Test", found.get().getName());
    }

    // Test FName ของ Customer ต้องไม่มีค่าว่างอยู่
    @Test
    void testOrderNameMustNotBeNull() {
        Order order = new Order();
        order.setFname(null);
        

        Set<ConstraintViolation<Order>> result = validator.validate(order);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Order> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("Order_name", v.getPropertyPath().toString());
    }
    }
}

