package com.PJ.Shipping.Controller;

import com.PJ.Shipping.Entity.Operation;
import com.PJ.Shipping.Repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OperationController {

    @Autowired
    private final OperationRepository OperationRepository;

    public OperationController(OperationRepository operationRepository) {
        this.OperationRepository = operationRepository;
    }

    @GetMapping("/Operation")
    public Collection<Operation> Operations() {
        return OperationRepository.findAll().stream().collect(Collectors.toList());
    }

}