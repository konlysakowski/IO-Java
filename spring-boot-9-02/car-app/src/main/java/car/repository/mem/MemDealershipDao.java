package car.repository.mem;

import org.springframework.stereotype.Component;
import car.repository.DealershipDao;
import car.model.Dealership;
import car.model.Model;

import java.util.List;
import java.util.stream.Collectors;

@Component("dealershipDao")
public class MemDealershipDao implements DealershipDao {

    @Override
    public List<Dealership> findAll() {
        return SampleData.dealerships;
    }

    @Override
    public Dealership findById(int id) {
        return SampleData.dealerships.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Dealership> findByModel(Model m) {
        return SampleData.dealerships.stream().filter(c -> c.getModels().contains(m)).collect(Collectors.toList());
    }
}
