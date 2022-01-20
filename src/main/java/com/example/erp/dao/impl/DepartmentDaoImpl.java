package com.example.erp.dao.impl;

import com.example.erp.bean.Department;
import com.example.erp.dao.DepartmentDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public  class DepartmentDaoImpl implements DepartmentDao {

   public boolean addDepartment(Department department)
    {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

//    public Department getDepartmentById(Integer department_id)
//    {
//        Session session = SessionUtil.getSession();
//        try {
//            // List<Object> record=new ArrayList<>();
//            Department department=new Department();
//            Query query = session.createQuery("from Department D where D.department_id=:i");
//            query.setParameter("i", department_id);
//            department = (Department)query.getSingleResult();
//            return department;
//        }
//        finally {
//            session.close();
//        }
//    }
}
