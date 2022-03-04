package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Course;
import com.ahojo.hibernate.demo.entity.Instructor;
import com.ahojo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {
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

            // get the Course from db
            int theId = 1;
            Course theCourse = session.get(Course.class, theId);

            // delete course
            System.out.println("Deleting the course: " + theCourse);
            session.delete(theCourse);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
