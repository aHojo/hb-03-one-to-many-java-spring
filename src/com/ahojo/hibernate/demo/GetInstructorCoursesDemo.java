package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Course;
import com.ahojo.hibernate.demo.entity.Instructor;
import com.ahojo.hibernate.demo.entity.InstructorDetail;
import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        // create the session

        Session session = factory.getCurrentSession();

        try {


            // start transaction
            session.beginTransaction();

            // get the instructor from db
            int theId = 1;
            Instructor theInstructor = session.get(Instructor.class, theId);


            System.out.println("Instructor: " + theInstructor);

            // get the courses for the instructor
            System.out.println("Courses: " + theInstructor.getCourses());
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
