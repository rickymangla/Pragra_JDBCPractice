package com.example.practicejdbc.dao;

import com.example.practicejdbc.model.Employee;
import org.hibernate.annotations.processing.SQL;
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
//    @Autowired
//    Employee employee;

    public List<Employee> getAllEmployees() {

        //use of anonymous inner class for functional interface implementation
//        RowMapper rm = new RowMapper() {
//            @Override
//            public Employee mapRow(ResultSet a, int rowNum) throws SQLException {
//                Employee employee = new Employee();
//                employee.setEmpName(a.getString("EMP_NAME"));
//                employee.setEmpId(a.getInt("EMP_ID"));
//                employee.setEmpSalary(a.getInt("EMP_SALARY"));
//                return employee;
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

        return jdbcTemplate.query(SQLQueries.getAllEmployees, rm);
    }

    private Employee employee(ResultSet a, int rowNum) throws SQLException {

        Employee employee = new Employee();
        employee.setEmpName(a.getString("EMP_NAME"));
        employee.setEmpId(a.getInt("EMP_ID"));
        employee.setEmpSalary(a.getInt("EMP_SALARY"));
        return employee;

/**
 employee.setEmpName(a.getString("EMP_NAME"));
 employee.setEmpId(a.getInt("EMP_ID"));
 employee.setEmpSalary(a.getInt("EMP_SALARY"));
 return employee;
 **/
    }

    public boolean addEmployee(Employee employee) {
        int rows = jdbcTemplate.update(SQLQueries.addEmployee,
                employee.getEmpName(), employee.getEmpId(), employee.getEmpSalary());
        return rows > 0;
    }

    public boolean updateEmployee(Employee employee) {
        int rows = jdbcTemplate.update(SQLQueries.updateEmployeeDetail,
                employee.getEmpName(), employee.getEmpId());
        return rows > 0;
    }

    public boolean deleteEmployee(int empId) {
        int rows = jdbcTemplate.update(SQLQueries.deleteEmployee, empId);
        return rows > 0;
    }

    public Employee getEmployeeDetail(Integer empId) {
        return jdbcTemplate.queryForObject(SQLQueries.getEmpDetail, new EmployeeDAO()::employee, empId);
    }
}
