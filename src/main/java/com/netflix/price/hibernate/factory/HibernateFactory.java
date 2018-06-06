package com.netflix.price.hibernate.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
private SessionFactory sessionFactory = buildSessionFactory();
private static final HibernateFactory hibernateFactory = new HibernateFactory();
private HibernateFactory(){

}
 static HibernateFactory getInstance(){
    return hibernateFactory;
}
private  SessionFactory buildSessionFactory() {
    try {
        // Create the SessionFactory from hibernate.cfg.xml
        return new Configuration().configure().buildSessionFactory();
    }
    catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
    }
}

public  SessionFactory getSessionFactory() {
    return sessionFactory;
}

public  void shutdown() {
    // Close caches and connection pools
    getSessionFactory().close();
}


}
