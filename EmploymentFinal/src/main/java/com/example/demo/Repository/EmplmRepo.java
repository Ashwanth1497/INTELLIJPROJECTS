package com.example.demo.Repository;

import com.example.demo.Model.Employments;

import java.util.List;

public interface EmplmRepo {
    Employments addEmployment (Employments employments);
    List<Employments> getEmploymentALL(Employments employments);
    Employments byEmployeeID(int emp_id);
}
