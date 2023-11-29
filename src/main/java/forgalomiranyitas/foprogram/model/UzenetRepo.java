package forgalomiranyitas.foprogram.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UzenetRepo extends CrudRepository<Uzenet, Integer> {
    List<Uzenet> findAllWithCustomOrderBy(Sort sort);
}
