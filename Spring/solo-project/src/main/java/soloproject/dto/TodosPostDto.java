package soloproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TodosPostDto {
    @NotBlank
    private String title;

    private int todo_order;

    private boolean completed;
}
