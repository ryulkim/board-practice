package boardcafe.boardpractice.todo.presentation;

import boardcafe.boardpractice.todo.application.TodoService;
import boardcafe.boardpractice.todo.application.response.TodosResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("ryula/todos")
public class TodoController {
    private final TodoService todoService;
    @GetMapping
    public ResponseEntity<TodosResponse> getTodos(){
        return ResponseEntity.ok().body(todoService.getTodos());
    }
}
