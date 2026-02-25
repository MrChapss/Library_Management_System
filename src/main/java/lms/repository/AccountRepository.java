package lms.repository;
// JpaRepository - a created set of save/delete method
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.model.User;
@Repository
public interface AccountRepository extends JpaRepository<User, Integer> {
	// this is where add/delete/update in the database
	// since I extend JpaRepository it already created CRUD methods
	boolean findByUsername(String username);
	boolean existsByUsername(String username);
	boolean findByUsernameAndPassword(String username, String password);
	User findPasswordByUsername(String username);
}
