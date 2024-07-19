package my.mood.JPA_Hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import my.mood.JPA_Hibernate.course.Course;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void delete(long id) {
		Course a = entityManager.find(Course.class, id);
		entityManager.remove(a);
	}
	
	public Course select(long id) {
		return entityManager.find(Course.class, id);
	}
	
}
