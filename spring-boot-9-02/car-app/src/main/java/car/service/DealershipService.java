package car.service;

import car.model.Dealership;
import car.model.Model;

import java.util.List;

public interface DealershipService {
//api zwraca nam wszystkie kina
    Dealership getDealershipById(int id);

    List<Dealership> getAllDealerships();

    List<Dealership> getDealershipByModels(Model m);

    List<Model> getModelsInDealership(Dealership c);

}
