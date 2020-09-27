package com.PJ.Shipping.Controller;

import com.PJ.Shipping.Entity.Gateway;
import com.PJ.Shipping.Repository.GatewayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class GatewayController {

    @Autowired
    private final GatewayRepository GatewayRepository;

    public GatewayController(GatewayRepository gatewayRepository) {
        this.GatewayRepository = gatewayRepository;
    }

    @GetMapping("/Gateway")
    public Collection<Gateway> Gateways() {
        return GatewayRepository.findAll().stream().collect(Collectors.toList());
    }

}