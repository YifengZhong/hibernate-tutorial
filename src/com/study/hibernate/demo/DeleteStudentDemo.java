package com.study.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
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
			session.beginTransaction();
			System.out.println("\nGetting student with id:" + studentId);
			Student myStudent = session.get(Student.class, studentId);
			//save the student object
			System.out.println("Delete the student..."+ myStudent);
			
			//delete the student
			session.delete(myStudent);
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

}
