package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo
{
    public static void main(String args[])
    {
//        create session factory
        SessionFactory factory = new Configuration()
                                    .configure()
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .buildSessionFactory();

//        crate session
        Session session = factory.getCurrentSession();

        try{
//            use the session object to save java object

//            create the objects
            System.out.println("Creating a new student object ....");

//            Instructor tempInstructor =
//                    new Instructor("Chad","Darby","darby@luv2code.com");
//
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail("http://www.luv2code.com/youtube","Luv 2 code !!!");

            Instructor tempInstructor =
                    new Instructor("Madhu","Patel","madhu@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com","Guitar");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

//            start a transaction
            session.beginTransaction();
//            save the student object
            System.out.println("Saving the Instructor ..."+tempInstructor);
            session.save(tempInstructor);
//            commit transaction

            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

    }
}
