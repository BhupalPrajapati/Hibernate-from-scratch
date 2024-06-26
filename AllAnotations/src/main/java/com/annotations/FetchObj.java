package com.annotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchObj {
	public static void main(String[] args) {

		// creating session factory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// now open the Session

		Session session = factory.openSession();

		// in this no need tranaction bcz won't save the data in the database

		// here we call the get() method
		Student student = (Student) session.get(Student.class, 60);

		System.out.println(student); // after call student obj then the Student string is call and details are print

		Address address = (Address) session.load(Address.class, 1); // it used when u r sure that the data exist in the
																	// database

		System.out.println(address.getCity());

		Address add = (Address) session.get(Address.class, 1);  // i was trying to duplicate the above data by using the get() method

		System.out.println(add.getCity() +":"+add.getAddressid());   //

		session.close();
		factory.close();
	}

}
