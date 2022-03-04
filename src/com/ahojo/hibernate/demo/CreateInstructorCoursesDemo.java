package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Course;
import com.ahojo.hibernate.demo.entity.Instructor;
import com.ahojo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorCoursesDemo {
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

            // create some courses
            Course course1 = new Course("Call of duty 1");
            Course course2 = new Course("xbox gaming");
            // add them to the instructor
            theInstructor.add(course1);
            theInstructor.add(course2);

            session.save(course1);
            session.save(course2);

            // save the courses
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
