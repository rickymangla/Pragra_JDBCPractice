package com.example.practicejdbc.dao;

public interface SQLQueries {
    String getAllEmployees = "SELECT * FROM EMPLOYEE";
    String addEmployee = "INSERT INTO EMPLOYEE VALUES(?,?,?)";
    String updateEmployeeDetail = "UPDATE EMPLOYEE SET EMP_NAME=? WHERE EMP_ID=?";
    String deleteEmployee = "DELETE FROM EMPLOYEE WHERE EMP_ID=?";
    String getEmpDetail = "SELECT * FROM EMPLOYEE WHERE EMP_ID=?";
}
