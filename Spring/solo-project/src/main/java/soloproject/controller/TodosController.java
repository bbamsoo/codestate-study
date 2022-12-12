package soloproject.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import soloproject.dto.TodosPatchDto;
import soloproject.dto.TodosPostDto;
import soloproject.entity.Todos;
import soloproject.mapper.TodosMapper;
import soloproject.service.TodosService;

import java.util.List;

@RestController
@RequestMapping("/")
@Validated
@Slf4j
public class TodosController {
    private final TodosService todosService;
    private final TodosMapper todosMapper;

    public TodosController(TodosService todosService, TodosMapper todosMapper) {
        this.todosService = todosService;
        this.todosMapper = todosMapper;
    }
    @PostMapping
    public ResponseEntity postTodos(@Valid @RequestBody TodosPostDto todosPostDto){
        Todos todos = todosService.createTodos(todosMapper.todosPostDtoToTodos(todosPostDto));

        return ResponseEntity.ok(todosMapper.todosToTodosResponseDto(todos));
    }
    @PatchMapping("/{todos-id}")
    public ResponseEntity patchTodos(
            @PathVariable("todos-id") @Positive long todosId,
            @Valid @RequestBody TodosPatchDto todosPatchDto){
        todosPatchDto.setTodosId(todosId);
        Todos todos = todosService.updateTodos(todosMapper.todosPatchDtoToTodos(todosPatchDto));

        return ResponseEntity.ok(todosMapper.todosToTodosResponseDto(todos));
    }
    @GetMapping("/{todos-id}")
    public ResponseEntity getTodos(@PathVariable("todos-id") @Positive long todosId){
        Todos todos = todosService.findTodos(todosId);
        return ResponseEntity.ok(todosMapper.todosToTodosResponseDto(todos));
    }
    @GetMapping
    public ResponseEntity pageTodos(@Positive @RequestParam int page,
                                    @Positive @RequestParam int size){
        Page<Todos> pageMembers = todosService.pageFindTodos(page - 1, size);
        List<Todos> pageTodos = pageMembers.getContent();
        return ResponseEntity.ok(todosMapper.todosToTodosResponseDtos(pageTodos));
    }
    @DeleteMapping("/{todos-id}")
    public ResponseEntity deleteTodos(@PathVariable("todos-id")long todosId){
        todosService.deleteTodos(todosId);

        return ResponseEntity.ok().build();
    }
}