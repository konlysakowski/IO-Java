package car.repository.data;

import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;
import car.repository.ModelDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataModelDao implements ModelDao {

    private final ModelRepository repository;

    @Override
    public List<Model> findAll() {
        return repository.findAll();
    }

    @Override
    public Model findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Model> findByManufacturer(Manufacturer m) {
        return repository.findAllByManufacturer(m);
    }

    @Override
    public List<Model> findByDealership(Dealership d) {
        return repository.findAllByDealershipsContaining(d);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public Model add(Model m) {
        return repository.save(m);
    }
}
