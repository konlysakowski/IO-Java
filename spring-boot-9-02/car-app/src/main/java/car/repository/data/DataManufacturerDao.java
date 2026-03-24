package car.repository.data;

import car.model.Manufacturer;
import car.repository.ManufacturerDao;
import jakarta.validation.constraints.Past;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataManufacturerDao implements ManufacturerDao {

    private final ManufacturerRepository repository;

    @Override
    public List<Manufacturer> findAll() {
        return repository.findAll();
    }

    @Override
    public Manufacturer findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Manufacturer add(Manufacturer d) {
        return repository.save(d);
    }
}
