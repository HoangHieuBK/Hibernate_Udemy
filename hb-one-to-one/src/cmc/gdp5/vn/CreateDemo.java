package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Instructor;
import cmc.gdp5.vn.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .buildSessionFactory();
		// create session	
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("creating object ...");
			// create  object
            Instructor instructor = new Instructor("bich", "ngoc", "bichngoc@gmail.com");
            InstructorDetail insDetail = new InstructorDetail("www.bichngoc.com", "lovely");

            // associate the objects
            instructor.setInstructorDetail(insDetail);
            
			// start a transaction
			session.beginTransaction();
				
			// save the instructor
			// this also will save insDetail object because of cascade = cascadeType.ALL
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Create successful!!!");
			
		} finally {
			factory.close();
		}
	}

}
