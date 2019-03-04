package cmc.gdp5.vn.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
 ////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String tittle;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;

	@OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;
	
	
	@ManyToMany(fetch=FetchType.LAZY,
			    cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable( name="course_student",
			    joinColumns=@JoinColumn(name="cours_id"),
			    inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;
	
	
	
	public Course() {
	}

	public Course(String tittle) {
		this.tittle = tittle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", tittle=" + tittle + ", instructor=" + instructor + "]";
	}
	
	// add convenience associate method with review
	public void addReview(Review revi) {
		if(reviews == null) {
			reviews = new ArrayList<Review>();
		}
		reviews.add(revi);
	}
	
	// add convenience associate method with student
	public void addStudent(Student theStudent) {
		if(students == null) {
			students = new ArrayList<Student>();
		}
		
		students.add(theStudent);
	}
	
}
