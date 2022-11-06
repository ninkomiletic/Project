package com.project.first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.first_project.entity.Course;
import com.project.first_project.entity.Instructor;
import com.project.first_project.entity.InstructorDetail;

public class DeleteCourses {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			int id1 = 2;
			int id2 = 3;
			Course course1 = session.get(Course.class, id1);
			Course course2 = session.get(Course.class, id2);
			
			session.delete(course1);
			session.delete(course2);
			session.getTransaction().commit();
		}
		finally{
			factory.close();
			session.close();
		}

	}

}
