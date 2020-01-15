package com.julia.road.repositories;

import com.julia.road.models.ServiceReq;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceReqRepo extends CrudRepository<ServiceReq, Long> {
}
