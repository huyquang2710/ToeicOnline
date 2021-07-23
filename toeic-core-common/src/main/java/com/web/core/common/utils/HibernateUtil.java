package com.web.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    // xu dung static de ko can phai khai bao doi tuong
    private static final SessionFactory sessionFactory = buildSessionFactory();
    // create sessionFactory from Hibernate
    private static SessionFactory buildSessionFactory() {
        try {
          return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Initial session factory fail!!!");
            throw new ExceptionInInitializerError(e);
        }
    }
    //Get sessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
