package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			deleteStudent(studentDAO);
			deleteStudentAll(studentDAO);
//			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		studentDAO.update(student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		Student theStudent = studentDAO.findByLastName("Sangwoo");
		System.out.println("Student Name : " + theStudent);
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent1 = new Student("Ahn", "Yeji", "ahn@naver.com");
		Student tempStudent2 = new Student("kim", "wonho", "kim@gmail.com");
		Student tempStudent3 = new Student("kang", "haneul", "kang@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("saved student. Generated id : " + tempStudent1.getId());
		System.out.println("saved student. Generated id : " + tempStudent2.getId());
		System.out.println("saved student. Generated id : " + tempStudent3.getId());
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id : " + studentId);
		studentDAO.delete(studentId);
	}

	private void deleteStudentAll(StudentDAO studentDAO) {
		System.out.println("Deleting all student");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count is " + numRowsDeleted);

	}

}
