package com.example.erp.bean;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Prerequisite implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer prereq_id;

    @Column(nullable = false ,unique = true)
    private String course_prerequisite_code;

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prerequisites")

    @ManyToMany(cascade=CascadeType.REMOVE,fetch = FetchType.EAGER)
    @JoinTable(name = "Course_Prerequisite", joinColumns = {@JoinColumn(name = "course_code")},
            inverseJoinColumns = {@JoinColumn(name = "course_prerequisite_code")})
//@ManyToMany(mappedBy = "prerequisites",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Courses> courses;

    public Prerequisite(String course_prerequisite_code, List<Courses> courses) {
        this.course_prerequisite_code = course_prerequisite_code;
        this.courses = courses;
    }

    public Prerequisite()
    {

    }


    public String getCourse_prerequisite_code() {
        return course_prerequisite_code;
    }

    public void setCourse_prerequisite_code(String course_prerequisite_code) {
        this.course_prerequisite_code = course_prerequisite_code;
    }
    @JsonbTransient
    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }
//    @ManyToMany
//    @JoinTable(name = "Course_Prerequisite", joinColumns = {@JoinColumn(name = "pre ")},
//            inverseJoinColumns = {@JoinColumn(name = "course_code")})
//    private List<Courses> course_code;






}

