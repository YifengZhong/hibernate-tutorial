package com.study.hibernate.oneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class DeletenstructorDemo {

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
			//get instructor by primary key id
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("found instructor" + tempInstructor);
			//delete the instructors
			if(tempInstructor != null) {
				System.out.println("Delete instructor" + tempInstructor);
				//Note: will also delete associate "detail" object
				//because of Cascadetype.ALL
				session.delete(tempInstructor);
			}
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
	}

}
