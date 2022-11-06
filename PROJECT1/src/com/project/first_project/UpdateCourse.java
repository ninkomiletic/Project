package com.project.first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.first_project.entity.Course;
import com.project.first_project.entity.Instructor;
import com.project.first_project.entity.InstructorDetail;

public class UpdateCourse {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int TheId = 2;
			Instructor instr = session.get(Instructor.class, TheId);
			
			Course course = new Course("JSLesson");
			
			instr.add(course);
			
			session.save(course)
;
			session.getTransaction().commit();
		}
		finally{
			session.close();
			factory.close();
		}
	}

}
