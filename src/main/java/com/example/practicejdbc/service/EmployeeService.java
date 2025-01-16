package com.example.practicejdbc.service;

import com.example.practicejdbc.dao.EmployeeDAO;
import com.example.practicejdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public boolean addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    public boolean deleteEmployee(int empId) {
        return employeeDAO.deleteEmployee(empId);
    }

    public Employee getEmployeeDetail(Integer empId) {
        return employeeDAO.getEmployeeDetail(empId);
    }




}
