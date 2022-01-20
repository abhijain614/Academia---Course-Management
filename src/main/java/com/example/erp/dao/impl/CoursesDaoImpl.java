package com.example.erp.dao.impl;

import com.example.erp.bean.Courses;
import com.example.erp.dao.CoursesDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CoursesDaoImpl implements CoursesDao {


    @Override
    public List<Courses> getCourses() {
        Session session = SessionUtil.getSession();
        List<Courses> courses = new ArrayList<>();
        try {
            for (final Object course : session.createQuery("from Courses ").list()) {
                courses.add((Courses) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return courses;
    }

    @Override
    public  boolean deleteCourses(Courses courses)
    {
        Session session = SessionUtil.getSession();
        try {
            Transaction tx = null;
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from Courses where course_id=:i");
            query.setParameter("i", courses.getCourse_id());
           // System.out.println("in course dao"+courses.getCourse_id());
             int status= query.executeUpdate();
            tx.commit();
           // System.out.println(status);
            if(status==1){
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
   public boolean updateCourses(Courses courses)
   {
       Session session = SessionUtil.getSession();
       try {
           Transaction tx = null;
           tx = session.beginTransaction();
           Query query = session.createQuery("update Courses set capacity=:b,course_code=:c,credits=:d,description=:e,faculty=:f,name=:g,term=:h,year=:i where course_id=:j");
           query.setParameter("j", courses.getCourse_id());


           query.setParameter("b", courses.getCapacity());
           query.setParameter("c", courses.getCourse_code());
           query.setParameter("d", courses.getCredits());
           query.setParameter("e", courses.getDescription());
           query.setParameter("f", courses.getFaculty());
           query.setParameter("g", courses.getName());
           query.setParameter("h", courses.getTerm());
           query.setParameter("i", courses.getYear());

           System.out.println("in course dao"+courses.getCourse_id());
           int status= query.executeUpdate();
           tx.commit();
            System.out.println(status);
           if(status==1){
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
   public Courses getCourse_data(Courses courses)
   {
       Session session = SessionUtil.getSession();

      // List<Courses> course_data = new ArrayList<>();

       Query query = session.createQuery("from Courses where course_id=:x");
       query.setParameter("x", courses.getCourse_id());
      return  (Courses)query.getSingleResult();



//       try {
//           for (final Object course : session.createQuery("from Courses where course_id=:i").list()) {
//               course_data.add((Courses) course);
//           }
//       } catch (HibernateException exception) {
//           System.out.print(exception.getLocalizedMessage());
//       }
     //  System.out.println("get_course_dao");

   }
@Override
   public boolean registerCourse(Courses courses){
       try (Session session = SessionUtil.getSession()) {
           Transaction transaction = session.beginTransaction();
           session.save(courses);
           transaction.commit();
           return true;
       } catch (HibernateException exception) {
           System.out.print(exception.getLocalizedMessage());
           return false;
       }
    }

    public Courses getCourseDetailsByCourseCode(String code)
    {
        Session session = SessionUtil.getSession();
        try {
            // List<Object> record=new ArrayList<>();
            Courses courses = new Courses();
            Query query = session.createQuery("from Courses C where C.course_code=:i");
            query.setParameter("i", code);
            return (Courses)query.getSingleResult();

        }
        finally {
            session.close();
        }
    }
@Override
    public int insertCoursePre(Courses courses)
    {
        Session session = SessionUtil.getSession();
        try {
            // List<Object> record=new ArrayList<>();
            Courses courses2 = new Courses();
            Query query = session.createQuery("update Courses set prerequisites=:a where course_id=:j");
            query.setParameter("j", courses2.getCourse_id());
            query.setParameter("a", courses2.getPrerequisites());
            return query.executeUpdate();

        }
        finally {
            session.close();
        }
    }
    }

