package com.example.demo.Repository;

import com.example.demo.Model.Employments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url ="http://localhost:8082", value = "employment-service")
public interface APIClient {
    @GetMapping("/Employment/{emp_id}")
    Employments getByID(@PathVariable int emp_id) ;
}
