package com.hibernate.HibernateExamples;

import com.hibernate.HibernateExamples.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class HibernateExampleSet {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Maheshbhai", "Patel",
                    "Harsh020201@gmail.com");

//            Set<String> images = student.getImages();
//            images.add("photo_01.jpg");
//            images.add("photo_02.jpg");
//            images.add("photo_03.jpg");
//            images.add("photo_04.jpg");
//            images.add("photo_04.jpg"); // automatically removed by Hashset.

            session.beginTransaction();
            session.persist(student);
            System.out.println("Student is saved successfully.");
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

