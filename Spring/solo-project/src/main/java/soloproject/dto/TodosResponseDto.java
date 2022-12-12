package soloproject.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TodosResponseDto {
    private long todosId;
    private String title;
    private int todo_order;
    private boolean completed;
}
