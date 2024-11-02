package boardcafe.boardpractice.todo.presentation.request;

import jakarta.validation.constraints.NotBlank;

public record TodoCreateRequest(String content) {
}
