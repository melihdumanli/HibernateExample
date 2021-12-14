package main.java.test;

import org.hibernate.Session;

import main.java.entity.CustomerEntity;
import main.java.entity.OrderEntity;
import main.java.entity.SalesRespEntity;
import main.java.enumx.Color;
import main.java.enumx.Gender;
import main.java.utils.Utils;

public class Test {
	
	public static void main(String[] args) {
		SalesRespEntity sr = new SalesRespEntity();
		// SalesRespEntity salesMan = new SalesRespEntity();
		
		CustomerEntity cs = new CustomerEntity();
		cs.setName("Melih");
		cs.setLastName("Dumanlý");
		cs.setAge(32);
		cs.setGender(Gender.MALE);
		cs.setSalesResponsible(sr);
		
		CustomerEntity cs1 = new CustomerEntity();
		cs1.setName("Mert Can");
		cs1.setLastName("Aydýn");
		cs1.setAge(32);
		cs1.setGender(Gender.MALE);
		cs1.setSalesResponsible(sr);
		
		CustomerEntity cs11 = new CustomerEntity();
		cs11.setName("Çaðrý");
		cs11.setLastName("Türkmen");
		cs11.setAge(32);
		cs11.setGender(Gender.MALE);
		cs11.setSalesResponsible(sr);
		
		OrderEntity order = new OrderEntity();
		order.setMake("Ford");
		order.setModel("Focus");
		order.setModelYear(2021);
		order.setColor(Color.BLACK);
		order.setCustomer(cs);
		order.setSalesMan(sr);
		
		OrderEntity order2 = new OrderEntity();
		order2.setMake("BMW");
		order2.setModel("G20");
		order2.setModelYear(2021);
		order2.setColor(Color.WHITE);
		order2.setCustomer(cs1);
		order2.setSalesMan(sr);
		
		sr.setName("Melih");
		sr.setLastName("Dumanlý");
		sr.setGender(Gender.MALE);
		sr.setTitle("Manager");
		sr.addCustomers(cs11);
		sr.addCustomers(cs1);
		sr.addCustomers(cs);
		sr.addOrders(order);
		sr.addOrders(order2);
		
		Session session = Utils.getSessionfactory().openSession();
		session.getTransaction().begin();
		session.persist(sr);
		session.getTransaction().commit();
		
	}
	
}
