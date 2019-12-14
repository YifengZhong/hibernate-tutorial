package com.study.hibernate.oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

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
			Instructor tempInstructor = 
					new Instructor("chad","darby","darbhy@gemail.com");
			//associate the objects
			InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Luv 3 code!!!");
			//start a transaction
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			//save the instructor
			//Note: this will also save the details object
			//because of CascadeType.ALL
			System.out.println("Saveing instructor:"+tempInstructor);
			session.save(tempInstructor);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
	}

}
