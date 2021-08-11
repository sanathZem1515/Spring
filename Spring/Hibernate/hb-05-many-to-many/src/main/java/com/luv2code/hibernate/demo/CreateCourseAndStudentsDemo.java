package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo
{
    public static void main(String args[])
    {
//        create session factory
        SessionFactory factory = new Configuration()
                                    .configure()
                                    .addAnnotatedClass(Instructor.class)
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Course.class)
                                    .addAnnotatedClass(Review.class)
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

//        crate session
        Session session = factory.getCurrentSession();

        try{
//            start a transaction
            session.beginTransaction();

//            create a course
            Course tempCourse = new Course("Pacman -how to Score One Million Points");

            session.save(tempCourse);

            Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
            Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
            //            add some reviews
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

//            save the course and leverage cascade all
            System.out.println("Saving the students");


            session.save(tempStudent1);
            session.save(tempStudent2);

            System.out.println("saved students "+tempCourse.getStudents());

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
