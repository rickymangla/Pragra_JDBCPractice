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
}
