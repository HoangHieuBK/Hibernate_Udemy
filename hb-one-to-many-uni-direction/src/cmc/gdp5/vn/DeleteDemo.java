package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Instructor;
import cmc.gdp5.vn.entity.InstructorDetail;

public class DeleteDemo {

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
			
			System.out.println("Delete object ...");
            
			// start a transaction
			session.beginTransaction();
				
			// find instructor for delete
			Instructor inst = session.get(Instructor.class, 5);
			
			// delete the instructor	
			// this also will delete insDetail object because of cascade = cascadeType.ALL
			
			// remove the associate object reference, break bi-direction link
			
			InstructorDetail detail = inst.getInstructorDetail();
			detail.setInstructor(null);
			session.delete(inst);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Delete successful!!!");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// handle connection leak detected
			session.close();
			
			factory.close();
		}
	}

}
