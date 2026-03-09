package car.service;

import car.model.Manufacturer;
import car.model.Model;

import java.util.List;

public interface ModelService {

    List<Model> getAllModels();

    List<Model> getModelsByManufacturer(Manufacturer d);

    Model getModelById(int id);

    Model addModel(Model m);

    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(int id);

    Manufacturer addManufacturer(Manufacturer d);
}
