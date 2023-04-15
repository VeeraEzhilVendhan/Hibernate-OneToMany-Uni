package com.spring.onetomany.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseReviews {
	
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
			int reviewId=5;
			
			Review review=session.get(Review.class,reviewId);
			session.delete(review);
			
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}
		
	}

}
