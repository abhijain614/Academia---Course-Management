package com.example.erp.controller;

import com.example.erp.bean.Courses;
import com.example.erp.service.CoursesService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("courses")
public class CoursesController {

    CoursesService courseService = new CoursesService();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourses() {
        List<Courses> courses = courseService.getCourses();
        System.out.println("Controller Working");

        List<JSONObject> resultobject = new ArrayList<>();
        try {
            resultobject = getCourseJsonArray(courses);
        }
    catch (org.json.JSONException exception)
        {
            exception.printStackTrace();
        }
        if (courses == null) {
            return Response.noContent().build();
        }

        return Response.ok(resultobject.toString()).build();
    }

    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCourses(Courses courses)
    {
        System.out.println("in course controller"+courses.getCourse_id());
        boolean status=courseService.deleteCourses(courses);
        System.out.println(status);
        return (Response.ok().build());
        //return Response.status(203).build();
    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCourses(Courses courses)
    {
        System.out.println("in course controller"+courses.getCourse_id());
        boolean status=courseService.updateCourses(courses);
        System.out.println(status);
        return (Response.ok().build());
    }


    @POST
    @Path("/course_data")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_course_data(Courses courses)
    {
        //System.out.println("get_course_controller");
      Courses course_data= courseService.getCourse_data(courses);
      System.out.println(course_data.getCourse_code());
      return Response.ok().entity(course_data).build();
    }


    JSONArray jsonArray=new JSONArray();
    public List<JSONObject> getCourseJsonArray(List<Courses> courses) throws JSONException {
        List<JSONObject> jsonObjectList =new ArrayList<>();
        //List<JSONObject> jsonObjectList1=new ArrayList<>();
        try{
            for(Courses each_course:courses)
            {
                JSONObject jsonobject=new JSONObject();
                //  JSONArray jsonArray = ;
                jsonobject.put("course_id",each_course.getCourse_id());
                jsonobject.put("course_code",each_course.getCourse_code());
                jsonobject.put("name",each_course.getName());
                jsonobject.put("description",each_course.getDescription());
                jsonobject.put("year",each_course.getYear());
                jsonobject.put("term",each_course.getTerm());
                jsonobject.put("credits",each_course.getCredits());
                jsonobject.put("capacity",each_course.getCapacity());
                jsonobject.put("faculty",each_course.getFaculty());
                jsonobject.put("count",each_course.getStudents().size());
                jsonObjectList.add(jsonobject);
            }

        }
        catch (org.json.JSONException exception)
        {
            exception.printStackTrace();
        }
        return jsonObjectList;
    }



    }

