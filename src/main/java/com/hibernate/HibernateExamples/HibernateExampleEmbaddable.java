package com.hibernate.HibernateExamples;

import com.hibernate.HibernateExamples.entity.Address;
import com.hibernate.HibernateExamples.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateExampleEmbaddable {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("NarmadaBen", "Patel",
                    "Harsh020201@gmail.com");

            Address studentAddress = new Address();
            studentAddress.setCity("Rajpipla");
            studentAddress.setStreet("Rajput..Street..");
            studentAddress.setZipcode("393145");

            Address billingAddress = new Address();
            billingAddress.setCity("Ahmedabad");
            billingAddress.setStreet("Ragav residency");
            billingAddress.setZipcode("382330");

            student.setStudentAddress(studentAddress);
            student.setBillingAddress(billingAddress);

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

