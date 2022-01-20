package com.example.erp.dao.impl;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean emailVerify(Employee employee) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("from Employee E where E.email=:i and E.department=:j");
            query.setParameter("i", employee.getEmail());
          query.setParameter("j","admin");
               System.out.println("in dao"+employee.getEmail());
            System.out.println("in dao"+employee.getDepartment());

//            Query query1= session.createQuery("from Employee where department=:admin");
//            query1.setParameter("department",employee.getDepartment());
            if(query.getResultList().size()==1){
                return true;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }finally {
            session.close();
        }
        return false;
    }
@Override
    public boolean addEmployee(Employee employee)
    {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
