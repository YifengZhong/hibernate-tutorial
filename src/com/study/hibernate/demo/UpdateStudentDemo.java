package com.study.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			System.out.println("Update student object...");
			//start a transaction
			session.beginTransaction();
			//get the student object
			System.out.println("get the student...");
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("updateing student...");
			myStudent.setFirstName("Scooby");
			//commit transaction
			session.getTransaction().commit();
			
			//new Code
			//update email for all student
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@gmail.com'")
			.executeUpdate();
			
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
