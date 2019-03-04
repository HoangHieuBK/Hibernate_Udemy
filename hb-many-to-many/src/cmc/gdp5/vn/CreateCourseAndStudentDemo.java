package cmc.gdp5.vn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cmc.gdp5.vn.entity.Course;
import cmc.gdp5.vn.entity.Instructor;
import cmc.gdp5.vn.entity.InstructorDetail;
import cmc.gdp5.vn.entity.Review;
import cmc.gdp5.vn.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create session	
		Session session = factory.getCurrentSession();
		
		try {
			
			// create course
            Course course1 = new Course("Udemy");
            Course course2 = new Course("PHP");
            
            // create student
            Student student1 = new Student("tran", "thuong", "thuongtran@gmail.com");
            Student student2 = new Student("mai", "thu", "maithu@gmail.com");

			// start a transaction
			session.beginTransaction();
				
			// add student into course
			course1.addStudent(student1);
			course2.addStudent(student2);
			course2.addStudent(student1);
			
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
