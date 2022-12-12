package soloproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todosId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int todo_order;

    @Column(nullable = false)
    private Boolean completed;

    public Todos(String title, int todo_order, Boolean completed) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }
}
