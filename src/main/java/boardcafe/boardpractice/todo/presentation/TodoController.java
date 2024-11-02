package boardcafe.boardpractice.todo.presentation;

import boardcafe.boardpractice.todo.application.TodoService;
import boardcafe.boardpractice.todo.application.response.TodoItem;
import boardcafe.boardpractice.todo.application.response.TodosResponse;
import boardcafe.boardpractice.todo.presentation.request.TodoCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    @GetMapping
    public ResponseEntity<TodosResponse> getTodos(){
        return ResponseEntity.ok().body(todoService.getTodos());
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodo(@RequestBody TodoCreateRequest todoCreateRequest){
        final TodoItem todoItem = todoService.createTodo(todoCreateRequest);
        return ResponseEntity.created( URI.create("/todos"+todoItem.id())).body(todoItem);
    }
}
