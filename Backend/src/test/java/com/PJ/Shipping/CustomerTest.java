package com.SE.RoomBook;

import com.SE.RoomBook.Entity.Customer;
import com.SE.RoomBook.Repository.CustomerRepository;
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
public class CustomerTest{
    private Validator validator;
        
    @Autowired
    private CustomerRepository customerRepository;
    
    @BeforeEach
    public void setup(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    //Test ข้อมูลครบถูกต้อง
    @Test
    void testCustomerOKFullData(){
        Customer customer = new Customer();
        customer.setFname("Test");
        customer.setLname("Testtt");
        customer.setEmail("Test@ex.com");
        customer.setPhone("0994899370");
        

        customer = customerRepository.saveAndFlush(customer);
        Optional<Customer> found = customerRepository.findById(customer.getId());
        assertEquals("Test", found.get().getName());
        assertEquals("Testtt", found.get().getLname());
        assertEquals("Test@ex.com", found.get().getEmail());
        assertEquals("0994899370", found.get().getPhone());
        
    }
    // Test FName ของ Customer ต้องไม่มีค่าว่างอยู่
    @Test
    void testCustomerNameMustNotBeNull() {
        Customer customer = new Customer();
        customer.setFname(null);
        customer.setLname("Testtt");
        customer.setEmail("Test@ex.com");
        customer.setPhone("0994899370");
        

        Set<ConstraintViolation<Customer>> result = validator.validate(customer);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Customer> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("Fname", v.getPropertyPath().toString());
    }

    // Test LName ของ Customer ต้องไม่มีค่าว่างอยู่
    @Test
    void testCustomerNameMustNotBeNull() {
        Customer customer = new Customer();
        customer.setFname("test");
        customer.setLname(null);
        customer.setEmail("Test@ex.com");
        customer.setPhone("0994899370");
        

        Set<ConstraintViolation<Customer>> result = validator.validate(customer);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Customer> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("Lname", v.getPropertyPath().toString());
    }
   
    // Test Email ของ Customer ต้องไม่มีค่าว่างอยู่
    @Test
    void testCustomerEmailMustNotBeNull() {
        Customer customer = new Customer();
        customer.setFname("Test");
        customer.setLname("Testtt");
        customer.setEmail(null);
        customer.setPhone("0994899370");
        

        Set<ConstraintViolation<Customer>> result = validator.validate(customer);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Customer> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("Email", v.getPropertyPath().toString());
    }
    // Test Phone ของ Customer ต้องไม่มีค่าว่าง
    @Test
    void testCustomerPhoneMustNotBeNull() {
        Customer customer = new Customer();
        customer.setFname("Test");
        customer.setLname("Testtt");
        customer.setEmail("Test@ex.com");
        customer.setPhone(null);
        

        Set<ConstraintViolation<Customer>> result = validator.validate(customer);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Customer> v = result.iterator().next();
        assertEquals("must not be null", v.getMessage());
        assertEquals("Phone", v.getPropertyPath().toString());
    }
    // Test Email ของ Customer ต้องอยู่ใน form ของ Email คือมี @
    @Test
    void testCustomerEmailMustHaveAddress() {
        Customer customer = new Customer();
        customer.setFname("Test");
        customer.setLname("Testtt");
        customer.setEmail("Testex.com");
        customer.setPhone("0994899370");
       

        Set<ConstraintViolation<Customer>> result = validator.validate(customer);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Customer> v = result.iterator().next();
        assertEquals("must be a well-formed email address", v.getMessage());
        assertEquals("Email", v.getPropertyPath().toString());
    }
    // Test Phone ของ Customer ต้องมีเลข 10 ตัว
    @Test
    void testCustomePhoneMustHaveNumber() {
        Customer customer = new Customer();
        customer.setFname("Test");
        customer.setLname("Testtt");
        customer.setEmail("Test@ex.com");
        customer.setPhone("A123456789");
        

        Set<ConstraintViolation<Customer>> result = validator.validate(customer);

        // result ต้องมี error 1 ค่าเท่านั้น
        assertEquals(1, result.size());

        // error message ตรงชนิด และถูก field
        ConstraintViolation<Customer> v = result.iterator().next();
        assertEquals("must match \"\\d{10}\"", v.getMessage());
        assertEquals("Phone", v.getPropertyPath().toString());
    }
    
        
    }
}