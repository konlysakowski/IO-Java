package car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import car.repository.DealershipDao;
import car.repository.ManufacturerDao;
import car.repository.ModelDao;
import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;
import car.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ModelServiceBean implements ModelService {

    private static final Logger log = Logger.getLogger(ModelService.class.getName());

    @Autowired
    public void setManufacturerDao(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    private ManufacturerDao manufacturerDao;
    private DealershipDao dealershipDao;
    private ModelDao modelDao;

    public ModelServiceBean(ManufacturerDao manufacturerDao, DealershipDao dealershipDao, ModelDao modelDao) {
        this.manufacturerDao = manufacturerDao;
        this.dealershipDao = dealershipDao;
        this.modelDao = modelDao;
    }

    public List<Model> getAllModels() {
        log.info("searching all models...");
        return modelDao.findAll();
    }

    public List<Model> getModelsByManufacturer(Manufacturer d) {
        log.info("serching models by manufacturer " + d.getId());
        return modelDao.findByManufacturer(d);
    }

    public List<Model> getModelsInDealership(Dealership c) {
        log.info("searching models played in dealership " + c.getId());
        return modelDao.findByDealership(c);
    }

    public Model getModelById(int id) {
        log.info("searching model by id " + id);
        return modelDao.findById(id);
    }

    public List<Dealership> getAllDealerships() {
        log.info("searching all dealerships");
        return dealershipDao.findAll();
    }

    public List<Dealership> getDealershipsByModel(Model m) {
        log.info("searching dealerships by model " + m.getId());
        return dealershipDao.findByModel(m);
    }

    public Dealership getDealershipById(int id) {
        log.info("searching dealership by id " + id);
        return dealershipDao.findById(id);
    }

    public List<Manufacturer> getAllDirectors() {
        log.info("searching all directors");
        return manufacturerDao.findAll();
    }

    public Manufacturer getManufacturerById(int id) {
        log.info("searching manufacturer by id " + id);
        return manufacturerDao.findById(id);
    }

    @Override
    public Model addModel(Model m) {
        log.info("about to add model " + m);
        return modelDao.add(m);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return List.of();
    }

    @Override
    public Manufacturer addManufacturer(Manufacturer d) {
        log.info("about to add manufacturer " + d);
        return manufacturerDao.add(d);
    }

}
