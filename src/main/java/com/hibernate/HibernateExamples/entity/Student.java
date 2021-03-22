package com.hibernate.HibernateExamples.entity;


import com.sun.org.glassfish.external.statistics.Stats;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student", schema = "hb_01_advance")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Embedded // optional
    private Address studentAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "billing_street")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "billing_zipcode"))
    })
    private Address billingAddress;


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;


//    @ElementCollection
//    @CollectionTable(name = "image",schema = "hb_01_advance",// default to student_images
//            joinColumns = @JoinColumn(name = "student_id"))
//    @OrderColumn
//    @Column(name = "file_name") //default to images
////    private Set<String> images= new HashSet<>();
//    private List<String> images = new ArrayList<>();

/*
    Map example
*/
//    @ElementCollection
//    @CollectionTable(name = "image",schema = "hb_01_advance") // default to studetn_images
//    @MapKeyColumn(name = "file_name")
//    @Column(name = "image_name")
//    private Map<String,String> images= new HashMap<>();



    /*SortedSet*/
//    @ElementCollection
//    @CollectionTable(name = "image",schema = "hb_01_advance")
//    @OrderBy("file_name DESC")
//    @Column(name = "file_name")
//    private Set<String> images= new LinkedHashSet<>();

    /*SortedMap*/
//    @ElementCollection
//    @CollectionTable(name = "image",schema = "hb_01_advance")
//    @MapKeyColumn(name = "file_name")
//    @Column(name = "image_name")
//    @OrderBy("file_name DESC ")
//    @SortComparator(ReverseStringCompator.class)
//    private SortedMap<String,String> images= new TreeMap<>();

    /*Reverse String*/
    public static class ReverseStringCompator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
