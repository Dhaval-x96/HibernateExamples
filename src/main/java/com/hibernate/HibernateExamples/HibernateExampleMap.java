package com.hibernate.HibernateExamples;

import com.hibernate.HibernateExamples.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HibernateExampleMap {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("NarmadaBen", "Patel",
                    "Harsh020201@gmail.com");

//            Map<String,String> images= new HashMap<>();
//            images.put("Photo_1.jpg","family vacation......");
//            images.put("Photo_2.jpg","friend get together........");
//            images.put("Photo_3.jpg","annual fuction......");
//            images.put("Photo_4.jpg","childhood memories......");
//
//            student.setImages(images);
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

