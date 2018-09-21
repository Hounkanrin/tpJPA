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

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUser(Employee E){
        jpaTest.addEmployee(E);
        return "hello";
    }

    @GET
    @Path("/department")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> departmentList(){
       return jpaTest.listDepartment();

    }

    @GET
    @Path("/employer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee employee(@PathParam(value="id") Long id){
        return jpaTest.employee(id);

    }

    @GET
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String delete(@PathParam(value="id") Long id)
    {
        return jpaTest.deleteEmployee(id);
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateEmployee(@PathParam(value="id") Long id, PersonDTO persob){
        System.err.println(persob.getName());

       return jpaTest.updateEmployee(id, persob.getName());
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateEm(Employee employee){

        return jpaTest.updateE(employee);
    }


}