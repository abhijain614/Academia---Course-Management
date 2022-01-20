package com.example.erp.service;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.dao.impl.EmployeeDaoImpl;


public class EmployeeService {

    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public boolean verifyEmail(Employee employee){
        return employeeDao.emailVerify(employee);
    }

}
