package com.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedOb {
	public static void main(String[] args) {
		// creating session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		// creating student object
		
		Student student1 = new Student();
		student1.setName("Bhupal");
		student1.setId(10);
		student1.setCity("Pune");
		
		// new creating the object of the Certificate bcz it has two attribute(course nd duration). 
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Rust");
		certificate.setDuration("1 month");
		
		student1.setCert(certificate);
		
		
		// for another student
		
		
		Student student2 = new Student();
		student2.setName("Ankit");
		student2.setId(12);
		student2.setCity("Nepal");
		
		// new creating the object of the Certificate bcz it has two attribute(course nd duration). 
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("TyepScrpit");
		certificate1.setDuration("0.9 month");
		
		student2.setCert(certificate1);
		
		
		// Open session
		Session session = factory.openSession();
		
		// Transaction begins
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		
		// commit the transaction
		tx.commit();
		
	
		session.close();
		
		factory.close();

	}

}
