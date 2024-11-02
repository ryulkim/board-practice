package boardcafe.boardpractice.todo.domain;

import boardcafe.boardpractice.common.auditing.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Todo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String content;
    private boolean completed=Boolean.FALSE;
    private boolean deleted=Boolean.FALSE;
}
