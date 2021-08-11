package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo
{
    public static void main(String args[])
    {
       //        create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

//        crate session
        Session session = factory.getCurrentSession();

        try{
//            use the session object to save java object

//            create a student object
            System.out.println("Creating 3 student objects ....");
            Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
            Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
            Student tempStudent3 = new Student("Bonita","Applebum","bonita@luv2code.com");
//            start a transaction
            session.beginTransaction();
//            save the student object
            System.out.println("Saving the students ...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
//            commit transaction

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
