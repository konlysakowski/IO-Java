package car.repository.data;

import car.model.Dealership;
import car.model.Model;
import car.repository.DealershipDao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataDealershipDao implements DealershipDao {

    private final DealershipRepository repository;

    @Override
    public List<Dealership> findAll() {return repository.findAll();}

    @Override
    public Dealership findById(int id) {return repository.findById(id).orElse(null);}

    @Override
    public List<Dealership> findByModel(Model m) {return repository.findAllByModel(m);}

    @Override
    public Dealership save(Dealership dealership) {return repository.save(dealership);}
}
