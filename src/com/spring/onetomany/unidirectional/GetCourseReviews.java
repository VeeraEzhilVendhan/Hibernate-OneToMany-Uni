package com.spring.onetomany.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseReviews {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			int id=10;
			Course course=session.get(Course.class, id);
			
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
		
		
		
		
	}

}
