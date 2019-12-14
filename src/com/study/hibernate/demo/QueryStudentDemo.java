package com.study.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			//query students: lastName="Duck"
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Duck");
			displayStudents(theStudents);
			//display the students
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

}
