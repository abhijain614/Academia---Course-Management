package com.example.erp.utils;

import com.example.erp.bean.*;
import com.example.erp.dao.*;
import com.example.erp.dao.impl.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

//    public static void main(String[] args) {
//
//     System.out.println("here to populate data");
//     populateDummyData();
//     }

    public static void populateDummyData(){
        populateDepartment();
        populateEmployees();
        populateStudents();
        populateCourses();
        populatePrerequisite();
    }

    public static void populateStudents() {

        Students s1=new Students("Abhinandan","Jain","abhi@gmail.com",null);
        Students s2=new Students("Pranay","Jain","pranay@gmail.com",null);
        Students s3=new Students("Sagar","Shirke","sagar@gmail.com",null);
        Students s4=new Students("Gopal","Goyal","gopal@gmail.com",null);
        Students s5=new Students("Ribhu","Mukherjee","ribhu@gmail.com",null);
        Students s6=new Students("Amartya","Pandit","amartya@gmail.com",null);
        StudentsDao studentsDao=new StudentsDaoImpl();
        studentsDao.addStudents(s1);
        studentsDao.addStudents(s2);
        studentsDao.addStudents(s3);
        studentsDao.addStudents(s4);
        studentsDao.addStudents(s5);
        studentsDao.addStudents(s6);

    }

    public static void populateCourses() {

        StudentsDao studentsDao = new StudentsDaoImpl();
        Students s1 = studentsDao.getStudentDetailsById(1);
        Students s2 = studentsDao.getStudentDetailsById(2);
        Students s3 = studentsDao.getStudentDetailsById(3);
        Students s4 = studentsDao.getStudentDetailsById(4);
        Students s5 = studentsDao.getStudentDetailsById(5);
        Students s6 = studentsDao.getStudentDetailsById(6);

        List<Students> Algo_students=new ArrayList<>();
        List<Students> SS_students=new ArrayList<>();
        List<Students> ML_students=new ArrayList<>();
        List<Students> NC_students=new ArrayList<>();
        List<Students> ASR_students=new ArrayList<>();
        List<Students> VR_students=new ArrayList<>();
        List<Students> WAN_students=new ArrayList<>();

        Algo_students.add(s1);
        SS_students.add(s2);
        ML_students.add(s3);
        Algo_students.add(s4);
        NC_students.add(s5);
        NC_students.add(s6);
        ASR_students.add(s1);
        ASR_students.add(s2);
        ASR_students.add(s3);
        VR_students.add(s4);
        VR_students.add(s5);
        WAN_students.add(s6);
        WAN_students.add(s1);


        Courses c1 = new Courses("Algorithms","Algorithms",4,1, "CS511",2020, 200, "Murlidhar",Algo_students);
        Courses c2 = new Courses("System Software","Software Systems - I",2,1, "CS513",2020, 200, "B.Thangaraju",SS_students);
        Courses c3 = new Courses("Computer Networks-I","Basics of Computer Networks",4,1, "NC501",2020, 100,"Debrata Das",NC_students);
        Courses c4 = new Courses("Maths for Machine Learning","Probability",2,1, "AI512",2020, 200,"S.Raghavan",ML_students);
        Courses c5 = new Courses("Automatic Speech Recognition","NLP",4,2, "AI700",2020, 200,"S.Raghavan",ASR_students);
        Courses c6 = new Courses("Visual Recognition","Visual algorithms",4,2, "AI800",2020, 200,"R. Subramanium",VR_students);
        Courses c7 = new Courses("Wireless Access Networks","Wireless Protocols",4,2, "NC700",2020, 50,"Debrata Das",WAN_students);
//        Courses c1 = new Courses("Algorithms","Algorithms",4,1, "CS511",2020, 200, "Murlidhar",Algo_students);
//        Courses c2 = new Courses("System Software","Software Systems - I",2,1, "CS513",2020, 200, "B.Thangaraju",SS_students);
////        Courses c3 = new Courses("Computer Networks-I","Basics of Computer Networks",4,1, "NC501",2020, 100, e1,
////                null, domainsECE,sECList);
//        Courses c4 = new Courses("Maths for Machine Learning","Probability",2,1, "AI512",2020, 200,"S.Raghavan",ML_students);
//
        CoursesDao coursesDao = new CoursesDaoImpl();

        coursesDao.registerCourse(c1);
        coursesDao.registerCourse(c2);
        coursesDao.registerCourse(c3);
        coursesDao.registerCourse(c4);
        coursesDao.registerCourse(c5);
        coursesDao.registerCourse(c6);
        coursesDao.registerCourse(c7);
    }

    public static void populatePrerequisite() {

        CoursesDao coursesDao = new CoursesDaoImpl();
        Courses c1 = coursesDao.getCourseDetailsByCourseCode("CS511");  //algo
        Courses c2 = coursesDao.getCourseDetailsByCourseCode("CS513");  //ss
        Courses c3 = coursesDao.getCourseDetailsByCourseCode("AI512");  //mml
        Courses c4 = coursesDao.getCourseDetailsByCourseCode("NC501");  //nc
        Courses c5 = coursesDao.getCourseDetailsByCourseCode("AI700");  //ASR has prereq as AI512
        Courses c6 = coursesDao.getCourseDetailsByCourseCode("AI800");  //VR has prereq as AI512
        Courses c7 = coursesDao.getCourseDetailsByCourseCode("NC700");  //WAN has prereq as NC501

        List<Courses> ML_prerequisite=new ArrayList<>(); //courses having ML as prerequisite
        List<Courses> NC_prerequisite=new ArrayList<>();  //courses having NC as prerequisite

        ML_prerequisite.add(c5);
        ML_prerequisite.add(c6);
        NC_prerequisite.add(c7);

        Prerequisite p1=new Prerequisite("AI512",ML_prerequisite);
        Prerequisite p2=new Prerequisite("NC501",NC_prerequisite);

        PrerequisiteDao prerequisiteDao = new PrerequisiteDaoImpl();

        prerequisiteDao.registerPrerequisite(p1);
        prerequisiteDao.registerPrerequisite(p2);

        List<Prerequisite> ASR_courses_pre=new ArrayList<>();
        List<Prerequisite> VR_courses_pre=new ArrayList<>();
        List<Prerequisite> WAN_courses_pre=new ArrayList<>();

        ASR_courses_pre.add(p1);
        VR_courses_pre.add(p1);
        WAN_courses_pre.add(p2);

        c5.setPrerequisites(ASR_courses_pre);
        c6.setPrerequisites(VR_courses_pre);
        c7.setPrerequisites(WAN_courses_pre);


        CoursesDao coursesDao1 = new CoursesDaoImpl();
        coursesDao1.insertCoursePre(c5);
        coursesDao1.insertCoursePre(c6);
        coursesDao1.insertCoursePre(c7);

    }



    public static void populateDepartment() {
        Department d1 = new Department("Computer Science & Engineering", 300);
        Department d2 = new Department("admin", 10);
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        departmentDao.addDepartment(d1);
        departmentDao.addDepartment(d2);
    }

    public static void populateEmployees() {
       // DepartmentDao deptDAO = new DepartmentDaoImpl();
      //  Department d1 = deptDAO.getDepartmentById(1);
     //   Department d2 = deptDAO.getDepartmentById(2);
        Employee e1 = new Employee("Jyotsna", "Bapat", "jyotsna.bapat@iiitb.org", "Prof", null,"CSE");
        Employee e2 = new Employee("Muralidhara", "VN", "muralidhara.vn@iiitb.org", "Prof",null, "CSE");
        Employee e3 = new Employee("abhi", "jain", "abhi@gmail.com", "Prof", null,"admin");
        Employee e4 = new Employee("Ramasubramanian", "V", "ramasubramanian.v@iiitb.org", "Prof",null, "CSE");
        EmployeeDao employeesDAO = new EmployeeDaoImpl();
        employeesDAO.addEmployee(e1);
        employeesDAO.addEmployee(e2);
        employeesDAO.addEmployee(e3);
        employeesDAO.addEmployee(e4);
    }
}
