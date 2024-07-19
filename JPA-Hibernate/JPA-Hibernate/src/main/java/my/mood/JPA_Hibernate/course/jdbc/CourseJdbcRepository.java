package my.mood.JPA_Hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import my.mood.JPA_Hibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired 
	private JdbcTemplate springJdbcRepo;
	
	public String INSERT_QUERY =
		"""
			insert into Course(id, name, author) 
			values (?, ?, ?);
		""";
	
	public String DELETE_QUERY =
			"""
				delete from Course where id = ?;
			""";
	
	public String SELECT_QUERY =
			"""
				select * from Course where id = ?;
			""";
	
	public void insert(Course course) {
		springJdbcRepo.update(INSERT_QUERY, 
				course.getId(), course.getName(), course.getAuthor());
	}
	
	public void delete(long id) {
		springJdbcRepo.update(DELETE_QUERY, id);
	}
	
	public Course select(long id) {
		return springJdbcRepo.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Course.class), id);
	}
	
}
