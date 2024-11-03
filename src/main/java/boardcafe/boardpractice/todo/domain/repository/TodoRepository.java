package boardcafe.boardpractice.todo.domain.repository;

import boardcafe.boardpractice.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByIdAndDeletedFalse(Long id);
    List<Todo> findAllByDeletedFalse();
}
