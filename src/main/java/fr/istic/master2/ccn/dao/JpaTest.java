package fr.istic.master2.ccn.dao;

import fr.istic.master2.ccn.model.Department;
import fr.istic.master2.ccn.model.Employee;
import org.codehaus.jackson.map.util.JSONPObject;

import javax.persistence.*;

import java.util.List;

public class JpaTest {

    private EntityManager manager;

   /* public JpaTest(EntityManager manager) {
        this.manager = manager;
    }*/

    /**
     * @param
     */
    public JpaTest() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        manager = factory.createEntityManager();
    }

    public List<Employee> employeeList() {

        Query list = manager.createQuery("select a from Employee a");
        return list.getResultList();

    }

    public void createEmployees() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
        if (numOfEmployees == 0) {
            Department department = new Department("java");
            Department depart = new Department("php");
            manager.persist(department);
            manager.persist(depart);

            manager.persist(new Employee("Jakab Gipsz", department));
            manager.persist(new Employee("Captain Nemo", department));
            manager.persist(new Employee("Viviane H", depart));
            tx.commit();

        }
    }

   /* private void listEmployees() {
        List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
    }*/

    /**
     * @return
     */
    public List<Department> listDepartment() {
        Query department = manager.createQuery("select d From Department d");
        return department.getResultList();

    }

    public void addEmployee(Employee E) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.persist(E);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }

    }

    public Employee employee(Long id) {
        //Query query = manager.createQuery("select a from Employee a where a.id =:id");
        Employee emp = manager.find(Employee.class, id);
        return emp;

    }

    public String deleteEmployee(Long id) {
        Employee em = manager.find(Employee.class, id);
        manager.getTransaction().begin();
        manager.remove(em);
        manager.getTransaction().commit();
        return "employee deleted" + em.getName();
    }


    public String updateEmployee(Long id, String name) {
        Employee em = manager.find(Employee.class, id);
        manager.getTransaction().begin();
        em.setName(name);
        manager.merge(em);
        manager.getTransaction().commit();
        return "modified";
    }
    public String updateE(Employee employee) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            manager.merge(employee);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        return "Employee updated";
    }

    }









