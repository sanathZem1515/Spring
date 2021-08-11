package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo
{
    public static void main(String args[])
    {
//        create session factory
        SessionFactory factory = new Configuration()
                                    .configure()
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .buildSessionFactory();

//        crate session
        Session session = factory.getCurrentSession();

        try{

            Instructor tempInstructor =
                    new Instructor("Susan","Public","susan.public@luv2code.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com","Video games");

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
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
