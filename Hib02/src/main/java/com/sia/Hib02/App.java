package com.sia.Hib02;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory=HibernateUtilities.getSession();
    	Session session=factory.openSession();
    	session.beginTransaction();
    	//creating protien data
    	ProtienData protienData=new ProtienData();
    	protienData.setGoal(10);
    	protienData.setTotal(15);
    	
    	//creating user
    	User user=new User();
    	user.setId(1);

    	user.getHistory().add(new UserHistory(new Date(),"Id has been set"));
    	
    	user.setName("ron");
    	

    	user.getHistory().add(new UserHistory(new Date(),"Name has been set"));
    	
    	
    	user.setProtienData(protienData);
    	
    	user.getHistory().add(new UserHistory(new Date(),"Protien data added"));
    	
    	session.persist(user);
    	
    	session.getTransaction().commit();
    	
    	session.beginTransaction();
    	
    	User loadedUser=(User)session.load(User.class,1);
    	
    	for(UserHistory history: loadedUser.getHistory()) {
    		
    		System.out.println(history.getEntryTime()+"::"+history.getEntry());
    		
    	}
    	session.getTransaction().commit();
    	
    	
    	session.close();
    	HibernateUtilities.getSession().close();
    }
}
