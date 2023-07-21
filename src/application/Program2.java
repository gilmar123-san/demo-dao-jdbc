package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		new DaoFactory();
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findByID ===");
		Department dep = depDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");		
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: department insert ===");		
		Department dep2 = new Department(null, "Food");
		depDao.insert(dep2);
		System.out.println("Inserted! New Id = " + dep2.getId());
		
		System.out.println("\n=== TEST 4: department update ===");		
		Department dep3 = depDao.findById(7);
		dep3.setName("iFood");
		depDao.update(dep3);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ===");	
		System.out.println("Enter Id for delete test:");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed! Id = " + id);
		
		sc.close();
	}
}
