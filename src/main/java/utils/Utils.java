package main.java.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import main.java.entity.CustomerEntity;
import main.java.entity.OrderEntity;
import main.java.entity.SalesRespEntity;

public class Utils {
	private static final SessionFactory sf = sessionFactory();
	
	private static SessionFactory sessionFactory() {
		try {
			Configuration configuration = new Configuration();
			
			configuration.addAnnotatedClass(CustomerEntity.class);
			configuration.addAnnotatedClass(SalesRespEntity.class);
			configuration.addAnnotatedClass(OrderEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public static SessionFactory getSessionfactory() {
		return sf;
	}
	
}
