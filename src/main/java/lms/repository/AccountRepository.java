package lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import lms.model.User;

@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {
	// this is where they add/delete/update in the database
	// since I extend JpaRepository it already created CRUD methods
	
	public void deleteByUsernameAndPassword(String username, String password);
	public boolean existsByUsername(String username);
}
