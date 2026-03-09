package car.repository;

import car.model.Manufacturer;

import java.util.List;

public interface ManufacturerDao {

    List<Manufacturer> findAll();

    Manufacturer findById(int id);

    Manufacturer add(Manufacturer d);


}
