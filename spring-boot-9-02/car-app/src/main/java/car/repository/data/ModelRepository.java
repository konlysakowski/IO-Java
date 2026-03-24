package car.repository.data;

import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findAllByManufacturer(Manufacturer m);

    List<Model> findAllByDealershipsContaining(Dealership d);
}
