package car.repository;

import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;

import java.util.List;

public interface ModelDao {

    List<Model> findAll();

    Model findById(int id);

    List<Model> findByManufacturer(Manufacturer m);

    List<Model> findByDealership(Dealership d);

    Model add(Model m);

}
