package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
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
        System.out.println("\n=== TEST 4: Seller -> insert ===");
        Seller newSeller=new Seller(null,"Greg","greg@gmail.com", LocalDate.now(),4000.0,new Department(2,null));
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = "+newSeller.getId());
        System.out.println("\n=== TEST 5: Seller -> update ===");
        seller=sellerDao.findById(9);
        seller.setBirthDate(LocalDate.of(1985,8,28));
        sellerDao.update(seller);
        System.out.println("Update completed!");
        System.out.println("\n=== TEST 6: Seller -> deleteById ===");
        sellerDao.deleteById(10);
        System.out.println("Delete completed!");


        DB.closeConnection();
    }
}
