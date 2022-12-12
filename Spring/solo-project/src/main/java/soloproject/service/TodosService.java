package soloproject.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import soloproject.entity.Todos;
import soloproject.exception.BusinessLogicException;
import soloproject.exception.ExceptionCode;
import soloproject.repository.TodosRepository;

import java.util.Optional;

@Service
public class TodosService {
    private final TodosRepository todosRepository;

    public TodosService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }
    public Todos createTodos(Todos todos){
        return todosRepository.save(todos);
    }
    public Todos updateTodos(Todos todos){
        Todos findTodos = findVerifiedTodos(todos.getTodosId());

        Optional.ofNullable(todos.getTitle())
                .ifPresent(title -> findTodos.setTitle(title));
        Optional.ofNullable(todos.getTodo_order())
                .ifPresent(todo_order -> findTodos.setTodo_order(todo_order));
        Optional.ofNullable(todos.getCompleted())
                .ifPresent(completed -> findTodos.setCompleted(completed));

        return todosRepository.save(findTodos);
    }
    public Todos findTodos(long todosId){
        return findVerifiedTodos(todosId);
    }
    public Page<Todos> pageFindTodos(int page, int size){
        return todosRepository.findAll(PageRequest.of(page, size,
                Sort.by("todosId").ascending()));
    }
    public void deleteTodos(long todosId){
        Todos findTodos = findVerifiedTodos(todosId);

        todosRepository.delete(findTodos);
    }


    public Todos findVerifiedTodos(long todosId){
        Optional<Todos> optionalTodos = todosRepository.findById(todosId);
        Todos findTodos = optionalTodos.orElseThrow();

        return findTodos;
    }
}
