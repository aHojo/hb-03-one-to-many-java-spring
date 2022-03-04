package com.ahojo.hibernate.demo;


import com.ahojo.hibernate.demo.entity.Instructor;
import com.ahojo.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {
        // create the session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        // create the session

        Session session = factory.getCurrentSession();

        try {


            // start transaction
            session.beginTransaction();
            // Get Instructor by primary key
            int theid = 1;
            Instructor tempInst = session.get(Instructor.class, theid);

            System.out.println("Found the Instructor: " + tempInst);

            if (tempInst != null) {
                System.out.println("Deleting: " + tempInst);
                // will also delete the instructor detail because of CascadeType.ALL
                session.delete(tempInst);
            }

            // delete the instructor
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }


    }
}
