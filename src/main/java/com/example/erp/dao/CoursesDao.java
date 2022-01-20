package com.example.erp.dao;

import com.example.erp.bean.Courses;

import java.util.List;

public interface CoursesDao {
    List<Courses> getCourses();
    boolean deleteCourses(Courses courses);
    boolean updateCourses(Courses courses);
    Courses getCourse_data(Courses courses);
    boolean registerCourse(Courses courses);
    Courses getCourseDetailsByCourseCode(String code);
    int insertCoursePre(Courses courses);
}
