package fr.istic.master2.ccn.dao;

import fr.istic.master2.ccn.model.Department;
import fr.istic.master2.ccn.model.Employee;

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
    public JpaTest () {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        manager = factory.createEntityManager();
    }

    public List<Employee> employeeList() {

        Query list= manager.createQuery("select a from Employee a");
        return list.getResultList();

        /*EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createEmployees();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        test.listEmployees();
        manager.close();
        factory.close();
        System.out.println(".. done");*/

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

            manager.persist(new Employee("Jakab Gipsz",department));
            manager.persist(new Employee("Captain Nemo",department));
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
   public List<Department> listDepartment() {
        Query department= manager.createQuery("select d From Department d");
                return department.getResultList();

        }


    }




