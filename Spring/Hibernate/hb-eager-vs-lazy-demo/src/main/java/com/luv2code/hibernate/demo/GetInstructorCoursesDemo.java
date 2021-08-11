package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo
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
//            start a transaction
            session.beginTransaction();

//            get the instructor from db
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class,theId);

            System.out.println("Instructor "+ tempInstructor);

            System.out.println("Courses "+ tempInstructor.getCourses());
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
