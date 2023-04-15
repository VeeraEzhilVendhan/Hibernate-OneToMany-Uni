package com.spring.onetomany.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
	 
		SessionFactory sessionfactory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=sessionfactory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			Instructor inst1=new Instructor("John","N","John.n@gmail.com");
			InstructorDetails instdtl=new InstructorDetails("Learn with John", "reading");
			Course course=new Course("Digital marketing");
			Review review1=new Review("Good course");
			Review review2=new Review("Very helpful");
			Review review3=new Review("Great course");
			Review review4=new Review("Worst course");
			Review review5=new Review("Expecting more review");
			
			inst1.setInstructordetails(instdtl);								
			inst1.addCourse(course);
			course.addReview(review1);
			course.addReview(review2);
			course.addReview(review3);
			course.addReview(review4);
			course.addReview(review5);

			session.save(inst1);
			session.save(course);
			
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
			sessionfactory.close();
		}

	}

}
