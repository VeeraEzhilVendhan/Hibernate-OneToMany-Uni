package com.spring.onetomany.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursewithReviews {

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
		int courseId=10;
		
		Course course=session.get(Course.class, courseId);
		
		//it will also delete reviews of the course
		session.delete(course);
		System.out.println("Course and all reviews are deleted");
		
		session.getTransaction().commit();
		
	}
	finally
	{
		session.close();
		sessionFactory.close();
	}
	
}
}
