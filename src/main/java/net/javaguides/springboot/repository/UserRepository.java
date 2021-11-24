package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("SElECT u from User u Where u.username = :username")
	public User getUserByUsername(@Param("username") String username);

}
