package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        DepartmentDao dep= DaoFactory.createDepartmentDao();
        System.out.println("\n=== TEST 1 : Department -> insert ====");
        Department depTest=new Department(null,"Cleaning");
        dep.insert(depTest);
        System.out.println("Inserted! New Id = "+depTest.getId());
        System.out.println("\n=== TEST 2 : Department -> update ====");
        depTest.setName("Hygiene");
        dep.update(depTest);
        System.out.println("Update completed!");
        System.out.println("\n=== TEST 3 : Department -> delete ====");
        dep.deleteById(2);
        System.out.println("Delete completed");
        System.out.println("\n=== TEST 4 : Department -> findById ====");
        depTest=dep.findById(4);
        System.out.println(depTest);
        System.out.println("\n=== TEST 5 : Department -> findAll ====");
        List<Department> list=dep.findAll();
        list.forEach(System.out::println);


        DB.closeConnection();
    }
}
