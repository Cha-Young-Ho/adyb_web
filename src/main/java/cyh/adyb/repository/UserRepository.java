package cyh.adyb.repository;

import cyh.adyb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select m from user m where m.id = ?1")
    List<User> finduser(String id, String password);
};