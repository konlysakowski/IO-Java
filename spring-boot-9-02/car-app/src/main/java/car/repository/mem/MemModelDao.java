package car.repository.mem;

import org.springframework.stereotype.Component;
import car.repository.ModelDao;
import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemModelDao implements ModelDao {
    @Override
    public List<Model> findAll() {
        return SampleData.models;
    }

    @Override
    public Model findById(int id) {
        return SampleData.models.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Model> findByManufacturer(Manufacturer d) {
       return SampleData.models.stream().filter(m -> m.getManufacturer() == d).collect(Collectors.toList());
    }

    @Override
    public List<Model> findByDealership(Dealership c) {
        return SampleData.models.stream().filter(m -> m.getDealerships().contains(c)).collect(Collectors.toList());
    }

    @Override
    public Model add(Model m) {
        int max = SampleData.models.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.models.add(m);
        return m;
    }
}
