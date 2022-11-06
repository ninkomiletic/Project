package com.project.first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.first_project.entity.Course;
import com.project.first_project.entity.Instructor;
import com.project.first_project.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		try {
			Instructor instr = new Instructor("Ninko", "Miletic", "ninkomiletic@gmail.com");
			InstructorDetail instrD = new InstructorDetail("ninkoYoutube", "Basketball");
			
			instr.setInstructor_detail(instrD);
			
			session.beginTransaction();
			session.save(instrD);
			session.save(instr);
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
			factory.close();
		}
	}
	

}
