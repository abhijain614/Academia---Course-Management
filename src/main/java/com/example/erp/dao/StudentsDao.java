package com.example.erp.dao;

import com.example.erp.bean.Students;

public interface StudentsDao {

    boolean addStudents(Students students);
    Students getStudentDetailsById(Integer student_id);
}
