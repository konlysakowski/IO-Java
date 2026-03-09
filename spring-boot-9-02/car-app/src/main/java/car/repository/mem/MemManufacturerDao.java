package car.repository.mem;

import org.springframework.stereotype.Component;
import car.repository.ManufacturerDao;
import car.model.Manufacturer;

import java.util.List;

@Component
public class MemManufacturerDao implements ManufacturerDao {
    @Override
    public List<Manufacturer> findAll() {
        return SampleData.manufacturers;
    }

    @Override
    public Manufacturer findById(int id) {
        return SampleData.manufacturers.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Manufacturer add(Manufacturer d) {
        int max = SampleData.manufacturers.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.manufacturers.add(d);
        return d;
    }
}
