package car.repository.data;

import car.model.Dealership;
import car.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DealershipRepository extends JpaRepository<Dealership, Integer> {

    List<Dealership> findAllByNameContaining(String name);

    @Query("select c from Dealership c inner join c.models model where model=:model")
    List<Dealership> findAllByModel(@Param("model") Model model);
}
