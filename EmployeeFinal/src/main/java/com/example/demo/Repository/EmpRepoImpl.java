package com.example.demo.Repository;

import com.example.demo.Model.APIResponse;
import com.example.demo.Model.Employee;
import com.example.demo.Model.Employments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmpRepoImpl implements EmpRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private APIClient apiClient;

    @Override
    public Employee addEmployee(Employee employee) {
        String INSERT_QUERY = "INSERT INTO employeetable (emp_id,uid,password,first_name,last_name,username,email,avatar,gender,phone_number,social_insurance_number,date_of_birth)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] obj = { employee.getEmp_id(), employee.getUid(), employee.getPassword(), employee.getFirst_name(),
                employee.getLast_name(), employee.getUsername(), employee.getEmail(), employee.getAvatar(),
                employee.getGender(), employee.getPhone_number(), employee.getSocial_insurance_number(),
                employee.getDate_of_birth() };
        jdbcTemplate.update(INSERT_QUERY, obj);
        return employee;
    }

    @Override
    @Cacheable(cacheNames = "cache1", key = "'#key'")
    public List<Employee> getAllEmployeesOnly(Employee employee) {
        String GET_ALL_QUERY = "SELECT * FROM employeetable";
        return jdbcTemplate.query(GET_ALL_QUERY,BeanPropertyRowMapper.newInstance(Employee.class));
    }


    @Override

    public APIResponse getEmployeeById(int emp_id) {




        String GET_USER_BY_ID_QUERY = "SELECT * FROM  employeetable  WHERE emp_id = ?";
        Employee employee =  jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, BeanPropertyRowMapper.newInstance(Employee.class),
                emp_id);

        Employments employments = apiClient.getByID(employee.getEmp_id());

        APIResponse apiResponse = new APIResponse();
        apiResponse.setEmployee(employee);
        apiResponse.setEmployments(employments);
        return apiResponse;
    }

    @Override
    public Employee onlyEmoById(int emp_id) {
        String SHOW_BY_EMP_ID= "SELECT * FROM employeetable where emp_id = ?";
        Employee employee =  jdbcTemplate.queryForObject(SHOW_BY_EMP_ID, BeanPropertyRowMapper.newInstance(Employee.class),
                emp_id);
        return employee;
    }
}
