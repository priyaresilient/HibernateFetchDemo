package com.naksha.HibernateDemo;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Student s1 = new Student(102,"Naksha","CSE");
        Student s2 = new Student();
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
        //ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        s2 = (Student) session.get(Student.class, 102);
        System.out.println(s2);
        //session.save(s1);
        tx.commit();
    }
}
