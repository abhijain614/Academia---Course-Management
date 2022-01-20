package com.example.erp.controller;

import com.example.erp.bean.Employee;
import com.example.erp.service.EmployeeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("employee")
public class EmployeeController {

    EmployeeService employeeService=new EmployeeService();   //service object is created
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response loginEmployee(Employee employee) throws URISyntaxException {
        if(employeeService.verifyEmail(employee)){      //service function is called to verify email
            return Response.ok().build();
        }else{
            return Response.status(203).build();
        }
    }
}
