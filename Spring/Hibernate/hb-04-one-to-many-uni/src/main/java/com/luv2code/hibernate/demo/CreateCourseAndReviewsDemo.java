package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo
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
                                    .buildSessionFactory();

//        crate session
        Session session = factory.getCurrentSession();

        try{
//            start a transaction
            session.beginTransaction();

//            create a course
            Course tempCourse = new Course("Pacman -how to Score One Million Points");


//            add some reviews
            tempCourse.addReview(new Review("Great course ... loved it!"));
            tempCourse.addReview(new Review("cool course,job well done!"));
            tempCourse.addReview(new Review("what a dumb course,you are an idiot!"));

//            save the course and leverage cascade all
            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());


            session.save(tempCourse);

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
