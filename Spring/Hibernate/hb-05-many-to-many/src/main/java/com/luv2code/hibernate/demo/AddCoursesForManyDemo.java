package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForManyDemo
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

            int theId = 1;

            Student tempStudent = session.get(Student.class,theId);

            System.out.println("Loaded Student "+tempStudent);
            System.out.println("Courses "+ tempStudent.getCourses());

//            cretae more cousres

            Course tempCourse1 = new Course("Rubiks cube - How to speed cube");
            Course tempCourse2 = new Course("Atari 2600 - game development");

            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);


            session.save(tempCourse1);
            session.save(tempCourse2);

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
