package cyh.adyb.repository;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFileRepository extends JpaRepository<UserFile, String> {
};