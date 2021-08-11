package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo
{
    public static void main(String args[])
    {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

//        crate session
        Session session = factory.getCurrentSession();

        try{
//
            session.beginTransaction();
//            Query all students
            List<Student> theStudents = session.createQuery("from Student").list();
            displayStudents(theStudents);

//            query students:lastName="Doe"
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
            System.out.println("\n Students having last name Doe");
            displayStudents(theStudents);



//            Query student : lastName='Doe' OR firstName ='Daffy'

            theStudents = session.createQuery("from Student s where"
            +" s.lastName='Doe' OR s.firstName='Daffy'").list();
            System.out.println("\n Students having last name Doe OR firstName ='Daffy'");
            displayStudents(theStudents);


//            Query students where email LIKE '%luv2code.com'

            theStudents = session.createQuery("from Student s where"+" s.email LIKE '%luv2code.com'").list();
            System.out.println("\n Students having  email LIKE '%luv2code.com'");
            displayStudents(theStudents);



            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
