package com.project.first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.first_project.entity.Course;
import com.project.first_project.entity.Instructor;
import com.project.first_project.entity.InstructorDetail;

public class UpdateTitle {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			int id=1;
			Course course = session.get(Course.class, id);
			
			course.setTitle("UpdateLesson");
			
			session.save(course);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
			session.close();
		}
	}

}
