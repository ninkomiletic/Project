package com.project.first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.first_project.entity.Course;
import com.project.first_project.entity.Instructor;
import com.project.first_project.entity.InstructorDetail;

public class CreateCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();
			int Theid=2;
			Instructor instr = session.get(Instructor.class, Theid);

			Course course1 = new Course ("JavaLesson");
			Course course2 = new Course ("SpringLesson");
			
			instr.add(course1);
			instr.add(course2);

			
			session.save(course1);
			session.save(course2);

			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
	

}
