package cmc.gdp5.vn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Student;

public class UpdateStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Query student object ...");

			// start a transaction
			session.beginTransaction();
						
			// update student object
		   session.createQuery("update Student s set email='hoanghieu@gmail.com' "
		    		+ "where s.lastName like '%n%'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");

			
		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> students) {
		for(Student student : students) {
			System.out.println(student);
		}
	}

}
