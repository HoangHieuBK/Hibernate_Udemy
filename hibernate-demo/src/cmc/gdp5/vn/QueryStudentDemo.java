package cmc.gdp5.vn;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Student;

public class QueryStudentDemo {

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
			
			// query the student object           
			@SuppressWarnings("unchecked")
			List<Student> students = session.createQuery("from Student").list();
			
			// print result
			displayStudent(students);
			
			// query student object
		    students = session.createQuery("from Student s where s.lastName like '%n%'").list();
		    
			
			// print result
			displayStudent(students);
			
			// commit transaction
			session.getTransaction().commit();
			

			
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
