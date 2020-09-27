package com.PJ.Shipping.Repository;

import com.PJ.Shipping.Entity.Operation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public
interface   OperationRepository extends JpaRepository<Operation, Long> {
    Operation findById(long Operation_id);

    // Operation Isstock()
}