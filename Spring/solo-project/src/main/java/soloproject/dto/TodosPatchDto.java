package soloproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TodosPatchDto {
    private long todosId;

    @NotBlank
    private String title;

    private int todo_order;

    private boolean completed;

    public void setTodosId(long todosId){
        this.todosId = todosId;
    }
}
