package com.example.practicejdbc.api;

import com.example.practicejdbc.dao.EmployeeDAO;
import com.example.practicejdbc.model.Employee;
import com.example.practicejdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    //        @RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {

        //without using DB to to see get results
//        return Arrays.asList(new Employee("amit", 101, 2500),
//                new Employee("rahul", 102, 3500),
//                new Employee("robin", 103, 4500)
//        );

        //using DB to get all employees
        return employeeService.getAllEmployees();
    }

}
