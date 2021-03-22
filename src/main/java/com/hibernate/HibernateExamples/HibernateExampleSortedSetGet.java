package com.hibernate.HibernateExamples;

import com.hibernate.HibernateExamples.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class HibernateExampleSortedSetGet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            System.out.println("Retriving the images from image table..");
            int id = 1;
            Student student1 = session.get(Student.class, id);

            System.out.println("Retrived student is :- " + student1);
//            System.out.println("Associated images:- "+ student1.getImages());

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}

