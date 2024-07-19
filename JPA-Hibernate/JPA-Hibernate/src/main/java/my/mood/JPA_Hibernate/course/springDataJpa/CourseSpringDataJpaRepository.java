package my.mood.JPA_Hibernate.course.springDataJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import my.mood.JPA_Hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{

	// We can add here custom methods also;
	
	public List<Course> findByName(String name);
	
	public List<Course> findByAuthor(String author);
	
}
