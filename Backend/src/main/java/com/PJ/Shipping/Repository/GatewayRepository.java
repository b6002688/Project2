
package com.PJ.Shipping.Repository;

import com.PJ.Shipping.Entity.Gateway;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface GatewayRepository extends JpaRepository<Gateway, Long> {
    Gateway findById(long Gateway_id);

    //repository เป็นตัวติดต่อกับดาต้าเบส
}