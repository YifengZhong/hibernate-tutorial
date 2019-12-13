package com.study.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java Object
			//create 3 student object
			System.out.println("Create 3 students object...");
			Student tempStudent1 = new Student("Paul1","Wall","paul@gamil.com");
			Student tempStudent2 = new Student("Paul2","Wall","paul@gamil.com");
			Student tempStudent3 = new Student("Paul3","Wall","paul@gamil.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
