package com.abouerp.itlearn.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Abouerp
 */
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
