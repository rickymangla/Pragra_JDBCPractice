package com.example.practicejdbc.dao;

import com.example.practicejdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {

//        RowMapper rm = new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return null;
//            }
//        };

        //use of lambda expression
//        RowMapper rm1 = (a, b) -> {
//            Employee employee = new Employee();
//            employee.setEmpName(a.getString("EMP_NAME"));
//            employee.setEmpId(a.getInt("EMP_ID"));
//            employee.setEmpSalary(a.getInt("EMP_SALARY"));
//            return employee;
//        };

        //use of method reference
        RowMapper rm = new EmployeeDAO()::employee;

        return jdbcTemplate.query("SELECT * FROM EMPLOYEE", rm);
    }

    private Employee employee(ResultSet a, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setEmpName(a.getString("EMP_NAME"));
        employee.setEmpId(a.getInt("EMP_ID"));
        employee.setEmpSalary(a.getInt("EMP_SALARY"));
        return employee;
    }
}
