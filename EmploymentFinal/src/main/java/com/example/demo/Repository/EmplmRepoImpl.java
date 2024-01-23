package com.example.demo.Repository;

import com.example.demo.Model.Employments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmplmRepoImpl implements EmplmRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Employments addEmployment(Employments employments) {
        String INSERT_QUERY = "INSERT INTO employmenttable(emp_id,title,key_skill) VALUES(?,?,?)";
        Object[] objects = {employments.getEmp_id(),employments.getTitle(),employments.getKey_skill()};
        jdbcTemplate.update(INSERT_QUERY,objects);
        return employments;
    }

    @Override
    public List<Employments> getEmploymentALL(Employments employments) {
        String GET_ALL_QUERY = "SELECT * FROM employmenttable";

        return jdbcTemplate.query(GET_ALL_QUERY, BeanPropertyRowMapper.newInstance(Employments.class));
    }

    @Override
    public Employments byEmployeeID(int emp_id) {
        String GET_BY_ID = "SELECT * FROM employmenttable WHERE emp_id = ?";

        return jdbcTemplate.queryForObject(GET_BY_ID, BeanPropertyRowMapper.newInstance(Employments.class), emp_id);
    }
}
