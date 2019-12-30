package com.study.hibernate.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start a transaction
			session.beginTransaction();
			//create a course
			Course tempCourse = new Course("Pacman");
			
			//save the course ... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			session.save(tempCourse);
			System.out.println("Saved the course:" + tempCourse);
			//create the students
			Student tempStudent1 = new Student("Join", "Doe", "john@xxx.com");
			Student tempStudent2 = new Student("Marry", "public", "marry@xxx.com");
			//add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			
			
			//save the students
			System.out.println("\nSaving students ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved students:"+ tempCourse.getStudents());
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
