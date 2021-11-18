package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.entity.Teacher;
import net.javaguides.springboot.repository.StudentRepository;
import net.javaguides.springboot.repository.TeacherRepository;

@SpringBootApplication
public class SchoolManagementSystemProjectApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementSystemProjectApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Teacher teacher1 = new Teacher("Bob", "Pogi", "bob@gmail.com");
//		teacherRepository.save(teacher1);
//		
//		Teacher teacher2 = new Teacher("neth", "ganda", "neth@gmail.com");
//		teacherRepository.save(teacher2);
//		
//		Teacher teacher3 = new Teacher("mike", "pogs", "mike@gmail.com");
//		teacherRepository.save(teacher3);
	}

}
