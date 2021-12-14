package main.java.hql;

import org.hibernate.Session;

import main.java.utils.Utils;

public class Select {
	// private static final Logger logger
	public static void main(String[] args) {
		Session session = Utils.getSessionfactory().openSession();
		String hql = "FROM bilge_adam.student";
		
	}
	
}
