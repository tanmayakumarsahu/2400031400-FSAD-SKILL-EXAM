package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        CustomerAccount c = new CustomerAccount("John", "Premium Account", new Date(), "Active");
        session.save(c);

        session.getTransaction().commit();

        System.out.println("Record Inserted");

        session.beginTransaction();

        CustomerAccount ca = session.get(CustomerAccount.class, 1);
        ca.setName("John Updated");
        ca.setStatus("Inactive");

        session.update(ca);

        session.getTransaction().commit();

        System.out.println("Record Updated");

        session.close();
        factory.close();
    }
}