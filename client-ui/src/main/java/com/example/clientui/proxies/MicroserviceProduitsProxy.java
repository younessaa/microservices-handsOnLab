package com.example.clientui.proxies;

import com.example.clientui.beans.ProductBean;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-gateway")
@LoadBalancerClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {

    @GetMapping(value = "/products/Produits")
    List<ProductBean> listeDesProduits();


    @GetMapping( value = "/products/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);
}
