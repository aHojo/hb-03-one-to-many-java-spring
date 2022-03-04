package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Course;
import com.ahojo.hibernate.demo.entity.Instructor;
import com.ahojo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
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

            Instructor tempInstructor = new Instructor("Lin", "Hojnowski", "lin@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.lin.net/youtube", "COD");

            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start transaction
            session.beginTransaction();

            // Save the instructor
            // ** THIS WILL ALSO save the details object because of
            // CascadeType.ALL

            //
            System.out.println("Saving the instructor: " + tempInstructor);
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
