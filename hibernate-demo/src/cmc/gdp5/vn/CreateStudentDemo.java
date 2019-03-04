package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("creating new student object ...");
			// create a student object
			Student student1 = new Student("bich", "ngoc", "pearlsea@gmail.com");
			Student student2 = new Student("pham", "thu", "thu@gmail.com");
			Student student3 = new Student("tran", "tra", "tra@gmail.com");

			// start a transaction
			session.beginTransaction();
			
			// save the student object
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Create successful!!!");
			
		} finally {
			factory.close();
		}
	}

}
