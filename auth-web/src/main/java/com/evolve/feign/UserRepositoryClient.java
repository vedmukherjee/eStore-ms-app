package com.evolve.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserRepositoryClient", url = "http://localhost:8080", path = "/hello")
public interface UserRepositoryClient {

    @GetMapping
    public String getMsg();
}