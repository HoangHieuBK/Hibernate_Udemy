package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Course;
import cmc.gdp5.vn.entity.Instructor;
import cmc.gdp5.vn.entity.InstructorDetail;

public class CreateCourseDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .buildSessionFactory();
		// create session	
		Session session = factory.getCurrentSession();
		
		try {
			
			// create course
            Course course1 = new Course("Javascript");
            Course course2 = new Course("Angular 6");
            
			// start a transaction
			session.beginTransaction();
				
            // get instructor have id=1
			Instructor instructor = session.get(Instructor.class, 1);
			
			// add course into instructor
			instructor.addCourse(course1);
            instructor.addCourse(course2);
//			course1.setInstructor(instructor);
//			course2.setInstructor(instructor);
			
            // save course 
            session.save(course1);
            session.save(course2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Create successful!!!");
			
		} finally {
			// handle leak connection
			session.close();
			
			factory.close();
		}
	}

}
