package cyh.adyb.repository;

import cyh.adyb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

     //@Query("select m from user m where m.userId = ?1")
     //User finduser(String id, String password);


    User findByUserId(String id);
};