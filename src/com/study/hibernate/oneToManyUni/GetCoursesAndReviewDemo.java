package com.study.hibernate.oneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.study.hibernate.demo.entity.Student;

public class GetCoursesAndReviewDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			// get the course
			int theId=10;
			Course tempCourse = session.get(Course.class, theId);
			
			//print the course
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews()); 
			//print the cours reviews
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
