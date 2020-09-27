package com.PJ.Shipping;

import com.PJ.Shipping.Entity.*;
import com.PJ.Shipping.Repository.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ShippingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingApplication.class, args);
	}

	@Bean
	ApplicationRunner init(GatewayRepository gatewayRepository,OperationRepository operationRepository ) {
		return args -> {

			Stream.of("Kerry", "DHL", "Flash express", "Thailandpost").forEach(name -> {
				Gateway gateway = new Gateway(); // สร้าง Object
				gateway.setGateway_name(name); // set ชื่อ (name) ให้ Object
				gatewayRepository.save(gateway); // บันทึก Objcet
			});
			
			Stream.of("Stock","Queue", "Pack", "Handover").forEach(name -> {
				Operation operation = new Operation(); // สร้าง Object
				operation.setOperation_name(name); // set ชื่อ (name) ให้ Object
				operationRepository.save(operation); // บันทึก Objcet
			});
			


		};
	}

}
