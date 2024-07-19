package my.mood.JPA_Hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import my.mood.JPA_Hibernate.course.jdbc.CourseJdbcRepository;
import my.mood.JPA_Hibernate.course.jpa.CourseJpaRepository;
import my.mood.JPA_Hibernate.course.springDataJpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository courseJdbcRepository;

	@Autowired
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	private CourseSpringDataJpaRepository courseSpringDataJpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// --> using Spring JDBC
		
		courseJdbcRepository.insert(new Course(234, "Java", "CodeWithHarry"));
		courseJdbcRepository.insert(new Course(235, "Kotlin", "Denis Panjuta"));
		courseJdbcRepository.insert(new Course(232, "MySQL", "Apna College"));
		courseJdbcRepository.insert(new Course(224, "DSA", "Dinesh Varyani"));

		courseJdbcRepository.delete(232);
		
		System.out.println(courseJdbcRepository.select(234));
		System.out.println(courseJdbcRepository.select(235));
		System.out.println(courseJdbcRepository.select(224));	
	
		// --> using Spring JPA
	
		courseJpaRepository.insert(new Course(1, "Learn", "Me"));
		courseJpaRepository.insert(new Course(2, "Learned", "Me too"));
		courseJpaRepository.insert(new Course(3, "Learning", "you"));
		
		courseJpaRepository.delete(2);
		
		System.out.println(courseJpaRepository.select(1));
		System.out.println(courseJpaRepository.select(3));
		
		
		// --> using Spring Data JPA
		
		courseSpringDataJpaRepository.save(new Course(1, "Course_1", "Abc"));
		courseSpringDataJpaRepository.save(new Course(2, "Course_2", "Xyz"));
		courseSpringDataJpaRepository.save(new Course(3, "Course_3", "Pqr"));
		
		courseSpringDataJpaRepository.deleteById(3l);
		
		System.out.println(courseSpringDataJpaRepository.findById(1l));
		System.out.println(courseSpringDataJpaRepository.findById(2l));
		
		// Custom method from "CourseSpringDataJpaRepository"
		System.out.println(courseSpringDataJpaRepository.findByName("Course_2"));
		System.out.println(courseSpringDataJpaRepository.findByName(""));
		
		// Custom method from "CourseSpringDataJpaRepository"
		System.out.println(courseSpringDataJpaRepository.findByAuthor("Abc"));
		System.out.println(courseSpringDataJpaRepository.findByAuthor(""));		
		
	}
	
}
