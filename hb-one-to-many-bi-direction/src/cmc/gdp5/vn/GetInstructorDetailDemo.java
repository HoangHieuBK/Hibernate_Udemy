package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Course;
import cmc.gdp5.vn.entity.Instructor;
import cmc.gdp5.vn.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			// start a transaction
			session.beginTransaction();
				
			// find instructorDetail 
			InstructorDetail instDetail = session.get(InstructorDetail.class, 1);
			
			// print the instructorDetail and instructor
			// this also will print instructor object because of cascade = cascadeType.ALL
			System.out.println(instDetail);
			
			System.out.println("============================================================");
			
			System.out.println(instDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done successful!!!");
			
		} 
		catch (Exception e) {
            e.printStackTrace();
		}
		finally {
			// handle connnection leak detected
			session.close();
			
			factory.close();
		}
	}

}
