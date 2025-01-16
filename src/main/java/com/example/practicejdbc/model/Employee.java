package com.example.practicejdbc.model;

import org.springframework.stereotype.Component;

//this class is called POJO(plain old java object) class or DTO(data transfer object) class
//@Component
public class Employee {
    private String empName;
    private Integer empId;
    private Integer empSalary;

    public Employee() {
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Integer empSalary) {
        this.empSalary = empSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", empSalary=" + empSalary +
                '}';
    }

    public Employee(String empName, int empId, Integer empSalary) {
        this.empName = empName;
        this.empId = empId;
        this.empSalary = empSalary;
    }
}
