package soloproject.mapper;

import org.mapstruct.Mapper;
import soloproject.dto.TodosPatchDto;
import soloproject.dto.TodosPostDto;
import soloproject.dto.TodosResponseDto;
import soloproject.entity.Todos;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodosMapper {
    Todos todosPostDtoToTodos(TodosPostDto todosPostDto);
    Todos todosPatchDtoToTodos(TodosPatchDto todosPatchDto);
    TodosResponseDto todosToTodosResponseDto(Todos todos);
    List<TodosResponseDto> todosToTodosResponseDtos(List<Todos> todos);
}
