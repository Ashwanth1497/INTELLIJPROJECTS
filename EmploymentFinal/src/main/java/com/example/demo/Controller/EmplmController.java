package com.example.demo.Controller;

import com.example.demo.Model.Employments;
import com.example.demo.Repository.EmplmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Employment")
public class EmplmController {
    @Autowired
    private EmplmRepo emplmRepo ;

    @PostMapping
    public Employments addEmp(@RequestBody Employments employments) {
        return emplmRepo.addEmployment(employments);
    }

    @GetMapping("/{emp_id}")
    public Employments getByID(@PathVariable int emp_id) {
        return emplmRepo.byEmployeeID(emp_id);

    }

    @GetMapping
    public List<Employments> getAll(@RequestBody Employments employments) {
        return emplmRepo.getEmploymentALL(employments);

    }
}
