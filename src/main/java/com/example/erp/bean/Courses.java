package com.example.erp.bean;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer course_id;

    @Column(nullable = false ,unique = true)
    private String course_code;

    @Column(nullable = false)
    private String name;

    private String description;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer term;
    @Column(nullable = false)
    private Integer credits;
    @Column(nullable = false)
    private Integer capacity;
    private String faculty;



    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "Student_Courses", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Students> students;



//    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(name = "Course_Prerequisite", joinColumns = {@JoinColumn(name = "course_code")},
//            inverseJoinColumns = {@JoinColumn(name = "course_prerequisite_code")})
     @ManyToMany(mappedBy = "courses",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Prerequisite> prerequisites;


    @JsonbTransient
    public List<Prerequisite> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Prerequisite> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @JsonbTransient
    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

  public Courses()
  {

  }
    public Courses(String name, String description, Integer credits, Integer term, String course_code, Integer year, Integer capacity,String faculty,List<Students> students){
    //public Courses(String course_code, String name, String description, Integer year, Integer term, Integer credits, Integer capacity, String faculty,List<Students> students) {
        //this.course_id = course_id;
        this.course_code = course_code;
        this.name = name;
        this.description = description;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
        this.faculty = faculty;
        this.students=students;
    }
}
