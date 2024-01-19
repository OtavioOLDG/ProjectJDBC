package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		list2.forEach(System.out::println);
		
		/*System.out.println("\n=== TEST 4: seller insert ===");
		Seller seller2 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id: " + seller2.getId() + ";");*/
		
		System.out.println("\n=== TEST 4: seller update ===");
		Seller seller2 = sellerDao.findById(10);
		seller2.setName("Martha Waine");
		sellerDao.update(seller2);
		System.out.println("Update completed");
		
		
	}
}