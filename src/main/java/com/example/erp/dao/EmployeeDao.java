package com.example.erp.dao;

import com.example.erp.bean.Employee;

public interface EmployeeDao {
    boolean emailVerify(Employee employee);
     boolean addEmployee(Employee employee);
}
