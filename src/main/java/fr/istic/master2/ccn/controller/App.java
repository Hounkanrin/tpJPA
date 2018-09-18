package fr.istic.master2.ccn.controller;

/**
 * Hello world!
 *
 */

import fr.istic.master2.ccn.dao.JpaTest;
import fr.istic.master2.ccn.model.Department;
import fr.istic.master2.ccn.model.Employee;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.Produces;

@Path("/hello")
public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());
    private JpaTest jpaTest = new JpaTest();

    @GET
    public static Response getStatus() {
        return Response.status(Response.Status.OK).entity("JO").build();

    }

    @GET
    @Path("/test")
    public String hello() {

        return "Hello World!";
    }

    @GET
    @Path("/employee")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getListEmployee() {
        List<Employee> list= jpaTest.employeeList();
        return list;
}

    @POST
    @Path("/addEmployee")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee() {
        jpaTest.createEmployees();

    }

    @GET
    @Path("/department")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> departmentList(){
       return jpaTest.listDepartment();

    }
}