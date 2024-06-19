package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // sessionfactory is a interface, that's why we can't used the new(it is use for the creating the object of the sessionfactory)
        
       SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
       
        System.out.println(factory); // it is give the config with some random object
        System.out.println(factory.isClosed());  // it gives the true/false acco to ur factory closed or not.
        
        // Now we can used above factory object easily in anywhere in the project.\
        
        // creating student
        
        Student st = new Student();   // creating of the student
        st.setId(50);
        st.setCity("Mumbai");
        st.setName("John");
        
       System.out.println(st);
       
       // here we want to save the data into the table. for that we need to call the session factory here(bcz the save method directy we'nt call for that need to create Dao class
       // so here with the help of the sessionfactory we able to save it in the table
       
     // Session session = factory.openSession();         // when you open session 1st time then call openSession() method
       
       Session session = factory.getCurrentSession();    // after opening 1st session also called getCurrentSesssion() method
      
      Transaction tx=session.beginTransaction(); // here the transction begins with the help of the beginTracsctiotn
      
      session.save(st);     // data are saved
      
      tx.commit();    // for the physicall changes you need to commit , so here session is commit with the help of the getTranaction method
      
      
      session.close();  // after doing all the work with the session, you need to close it here
        
        
    }
}