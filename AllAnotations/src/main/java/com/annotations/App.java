package com.annotations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException   // for the image we used the throws Exception
    {
        System.out.println( "Hello World!" );
        
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        System.out.println(factory);
        
        Student st = new Student();  // creating of the student
        st.setId(60);
        st.setCity("Mumbai");
        st.setName("John");
        
       System.out.println(st);
       
       
       
       // creating object of te address
       
        Address ad = new Address();
     
        ad.setCity("Pune");
        ad.setStreet("Chock");
        ad.setOpen(true);
        ad.setX(0.3);
        ad.setImage(null);
        ad.setAddedDate(new Date());
        
        
     // here we uploading images
        
        FileInputStream fis = new FileInputStream("src/main/java/Pp.png");
        
        // new read the bytes of images with the help of array
        // Reloading Images
        
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
         
      
        
        System.out.println(ad);
        
        
        Session session = factory.openSession();    // after opening 1st session also called getCurrentSesssion() method
        
        Transaction tx=session.beginTransaction(); // here the transction begins with the help of the beginTracsctiotn
        
        session.save(st);     // save the student object
        
        session.save(ad);    // save the address object
        
        tx.commit();    // for the physicall changes you need to commit , so here session is commit with the help of the getTranaction method
        
        
        session.close(); 
        
    }
}
