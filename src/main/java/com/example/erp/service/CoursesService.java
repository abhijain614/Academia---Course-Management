package com.example.erp.service;

import com.example.erp.bean.Courses;
import com.example.erp.dao.CoursesDao;
import com.example.erp.dao.impl.CoursesDaoImpl;

import java.util.List;

public class CoursesService {

    CoursesDao coursesDao=new CoursesDaoImpl();

    public boolean deleteCourses(Courses courses) {
        System.out.println("in course service"+courses.getCourse_id());
        return coursesDao.deleteCourses(courses);
    }
    public boolean updateCourses(Courses courses)
    {
        System.out.println("in course update service"+ courses.getCourse_id());
        return coursesDao.updateCourses(courses);
    }
    public List<Courses> getCourses (){

        return coursesDao.getCourses();
//        System.out.println("student list size is"+courses.get(0).getStudents().size());
//        System.out.println("student name"+courses.get(0).getStudents().get(0).getFirst_name());
//
//        List<Data> data=new ArrayList<Data>();
//
//
//        for(int i=0;i<courses.size();i++)
//        {
//            Data d=new Data();
//            d.setCourse_id(courses.get(i).getCourse_id());
//            d.setCourse_code(courses.get(i).getCourse_code());
//            d.setName(courses.get(i).getName());
//            d.setDescription(courses.get(i).getDescription());
//            d.setYear(courses.get(i).getYear());
//            d.setTerm(courses.get(i).getTerm());
//            d.setCredits(courses.get(i).getCredits());
//            d.setCapacity(courses.get(i).getCapacity());
//            d.setFaculty(courses.get(i).getFaculty());
//            d.setCount(courses.get(i).getStudents().size());
//            data.add(i,d);
//        }
//        return courses;
    }

    public Courses getCourse_data (Courses courses){
       // System.out.println("get_course_service");
        return coursesDao.getCourse_data(courses);
    }


}
