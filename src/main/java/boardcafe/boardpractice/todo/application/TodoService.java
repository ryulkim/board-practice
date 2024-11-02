package boardcafe.boardpractice.todo.application;

import boardcafe.boardpractice.common.exception.ErrorCode;
import boardcafe.boardpractice.todo.application.response.TodoItem;
import boardcafe.boardpractice.todo.application.response.TodosResponse;
import boardcafe.boardpractice.todo.domain.Todo;
import boardcafe.boardpractice.todo.domain.repository.TodoRepository;
import boardcafe.boardpractice.todo.exception.TodoNotFoundException;
import boardcafe.boardpractice.todo.presentation.request.TodoCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly=true)
@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodosResponse getTodos(){
        final List<Todo> todos = todoRepository.findAll();
        return new TodosResponse(todos.stream()
                .map(TodoItem::of)
                .toList());
    }

    @Transactional
    public TodoItem createTodo(TodoCreateRequest todoCreateRequest){
        final Todo todo=todoRepository.save(new Todo(todoCreateRequest.content()));
        return TodoItem.of(todo);
    }

    @Transactional
    public void updateTodoCompleted(Long todoId){
        final Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new TodoNotFoundException(ErrorCode.NOT_FOUND_TODO_ID));
        todo.updateCompleted();
    }
}
