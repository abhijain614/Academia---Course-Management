package com.example.erp.dao.impl;

import com.example.erp.bean.Students;
import com.example.erp.dao.StudentsDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class StudentsDaoImpl implements StudentsDao {
@Override
    public boolean addStudents(Students students) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(students);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
@Override
    public Students getStudentDetailsById(Integer student_id) {
        Session session = SessionUtil.getSession();
        try {
            // List<Object> record=new ArrayList<>();
            Students students = new Students();
            Query query = session.createQuery("from Students S where S.student_id=:i");
            query.setParameter("i", student_id);
            students = (Students) query.getSingleResult();
            return students;
        }
        finally {
            session.close();
        }
    }
}