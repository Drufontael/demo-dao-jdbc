package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao= DaoFactory.createSellerDao();
        System.out.println("\n=== TEST 1: Seller -> findById ===");
        Seller seller=sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("\n=== TEST 2: Seller -> findByDepartment ===");
        List<Seller> sellers=sellerDao.findByDepartment(new Department(2,"Electronics"));
        for (Seller s:sellers){
            System.out.println(s);
        }

        System.out.println("\n=== TEST 3: Seller -> findAll ===");
        sellers=sellerDao.findAll();
        for (Seller s:sellers){
            System.out.println(s);
        }
        DB.closeConnection();
    }
}
