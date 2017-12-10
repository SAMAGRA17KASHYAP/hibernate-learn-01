package com.sia.Hib02;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilities {
	private static SessionFactory  sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	static {
		try {
			Configuration configuration=new Configuration().configure();
			serviceRegistry=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		}
		catch(HibernateException ex) {
			System.out.println("Something went wrong :"+ex);
		}
	}
	public static SessionFactory getSession() {
		return sessionFactory;
	}
}
