package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Instructor;
import com.ahojo.hibernate.demo.entity.InstructorDetail;
import com.ahojo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;


public class CreateDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create the session

        Session session = factory.getCurrentSession();

        try {
            // create the objects

//            Instructor tempInstructor = new Instructor("Andrew", "Hojnowski", "ahojodev@gmail.com");
//            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.ahojodev.net/youtube", "Programming");
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
            factory.close();
        }


    }
}
