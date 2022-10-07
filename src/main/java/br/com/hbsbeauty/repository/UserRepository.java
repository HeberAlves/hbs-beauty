package br.com.hbsbeauty.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hbsbeauty.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "SELECT u FROM User u")
	List<User> getAllUser();
	
	@Query(value = "SELECT u FROM User u WHERE u.id = :id")
	User getUserById(@Param("id")Integer id);
	
	
	

}
