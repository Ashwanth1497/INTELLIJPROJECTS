package com.example.demo.Repository;

import com.example.demo.Model.APIResponse;
import com.example.demo.Model.Employee;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface EmpRepo {
    Employee addEmployee(Employee employee);
    @Cacheable(cacheNames = "cache1", key = "'#key'")
    List<Employee> getAllEmployeesOnly(Employee employee);
    APIResponse getEmployeeById(int emp_id);
    Employee onlyEmoById(int emp_id);

}
