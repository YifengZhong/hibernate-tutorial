package com.study.hibernate.oneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
			session.beginTransaction();
			//get the instructor detail object
			int theId = 2098;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetail:" + tempInstructorDetail);
			//print the instructor detail
			//print the associate instructor
			System.out.println("the associated instructor:" +
					tempInstructorDetail.getInstructor());
			
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
			
		}
		finally {
			//handle connection leak issue
			session.close();
			factory.close();
		}
		
	}

}
