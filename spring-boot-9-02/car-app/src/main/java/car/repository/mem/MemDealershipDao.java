package car.repository.mem;

import org.springframework.stereotype.Component;
import car.repository.DealershipDao;
import car.model.Dealership;
import car.model.Model;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("dealershipDao")
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

    @Override
    public Dealership save(Dealership dealership) {
        int maxId = SampleData.dealerships.stream()
                .sorted((c1,c2)-> c2.getId()-c1.getId())
                .findFirst()
                .map(c->c.getId())
                .orElse(0);
        dealership.setId(maxId+1);
        SampleData.dealerships.add(dealership);
        return dealership;
    }
}
