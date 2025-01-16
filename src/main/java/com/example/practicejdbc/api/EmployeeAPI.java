package com.example.practicejdbc.api;

import com.example.practicejdbc.dao.EmployeeDAO;
import com.example.practicejdbc.model.Employee;
import com.example.practicejdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {
    @Autowired
    EmployeeService employeeService;
//    @Autowired
//    Employee employee;

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

    @PostMapping("/addEmployee")
    public String addEmployee() {
        Employee employee = new Employee();
        employee.setEmpName("john");
        employee.setEmpId(105);
        employee.setEmpSalary(6500);
        boolean result = employeeService.addEmployee(employee);
        if (result) {
            return "employee has been added successfully";
        } else {
            return "employee has not been added";
        }
    }

    @PutMapping("/updateEmployee")
    public String updateEmployeeDetail() {
        Employee employee = new Employee();
        employee.setEmpId(103);
        employee.setEmpName("hari");
        // employee.setEmpSalary(10500);
        boolean result = employeeService.updateEmployee(employee);
        if (result) {
            return "employee has been updated successfully";
        } else {
            return "employee has not been updated";
        }
    }

    @DeleteMapping("/deleteEmployee")
    public String deleteEmployee() {
        boolean result = employeeService.deleteEmployee(105);
        if (result) {
            return "employee has been deleted successfully";
        } else {
            return "employee has not been deleted";
        }
    }

    @GetMapping("/getEmployee")
    public Employee getEmployeeDetail(Integer id) {
        return employeeService.getEmployeeDetail(101);
    }
}
