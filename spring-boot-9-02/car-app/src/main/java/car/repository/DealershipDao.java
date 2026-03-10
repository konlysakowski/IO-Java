package car.repository;

import car.model.Dealership;
import car.model.Model;

import java.util.List;

public interface DealershipDao {

    List<Dealership> findAll();

    Dealership findById(int id);

    List<Dealership> findByModel(Model m);

    Dealership save(Dealership dealership);

}
