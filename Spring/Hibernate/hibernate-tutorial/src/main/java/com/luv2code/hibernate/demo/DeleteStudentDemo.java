package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo
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
            int studentId=1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class,studentId);


//            System.out.println("Deleting student"+myStudent);
//            session.delete(myStudent);
//            session.getTransaction().commit();

            System.out.println("Deleting student id=2");

            session.createQuery("delete from Student where id = 2").executeUpdate();
//            session.beginTransaction();


            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
