package com.hibernate.HibernateExamples;

import com.hibernate.HibernateExamples.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;
import java.util.TreeMap;

public class HibernateExampleSortedMapGet {


    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();
            Student student = session.get(Student.class, 2);
            System.out.println("Retrived student:- " + student);
            // System.out.println("Retrived images:- "+ student.getImages());

            session.persist(student);

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

