package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("reading student object ...");
			
			// start a transaction
			session.beginTransaction();
			
			// read the student object
			Student student = session.get(Student.class, 2);
			
			// commit transaction
			session.getTransaction().commit();
			
			// print result 
			System.out.println("Read successful!!!");
			System.out.println(student);
			
		} finally {
			factory.close();
		}
	}

}
