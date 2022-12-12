package soloproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soloproject.entity.Todos;

import java.util.Optional;

public interface TodosRepository extends JpaRepository<Todos,Long> {
    @Override
    Optional<Todos> findById(Long todosId);
}
