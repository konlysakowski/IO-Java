package car.repository.dummy;

import org.springframework.stereotype.Component;
import car.model.Dealership;
import car.model.Model;
import car.repository.DealershipDao;

import java.util.List;

@Component
public class DummyDealershipDao implements DealershipDao {

    @Override
    public List<Dealership> findAll() { return List.of(); }

    @Override
    public Dealership findById(int id) { return null; }

    @Override
    public List<Dealership> findByModel(Model m) { return List.of(); }

    @Override
    public Dealership save(Dealership dealership) { return null; }
}
