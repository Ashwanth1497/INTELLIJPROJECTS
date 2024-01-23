package com.example.demo.Controller;

import com.example.demo.Model.APIResponse;
import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Employees")
@EnableCaching
@EnableSwagger2
public class EmpController {


    @Autowired
    private EmpRepo empRepo;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {

        return empRepo.addEmployee(employee);

    }

    //@Cacheable(value = "Employee", key = "Employee")
    @GetMapping("/getEmpdddById/{emp_id}")
    public APIResponse getEmpById(@PathVariable int emp_id) {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empRepo.getEmployeeById(emp_id);
    }

    @GetMapping("/getAllEmpOnly")
    public List<Employee> getAllEmpOnly(Employee employee) {
        return empRepo.getAllEmployeesOnly(employee);

    }
    @GetMapping("/empByIdOnly/{emp_id}")
public Employee getOnlyEmpById (@PathVariable int emp_id){
        return empRepo.onlyEmoById(emp_id);
}

}
