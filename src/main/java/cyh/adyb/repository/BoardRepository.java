package cyh.adyb.repository;

import cyh.adyb.domain.Board;
import cyh.adyb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface BoardRepository extends JpaRepository<Board, Long> {
};