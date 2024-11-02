package boardcafe.boardpractice.todo.domain.repository;

import boardcafe.boardpractice.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
