package car.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import car.model.Dealership;
import car.model.Model;
import car.repository.DealershipDao;
import car.repository.ModelDao;
import car.service.DealershipService;

import java.util.List;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class DealershipServiceBean implements DealershipService {

    private static final Logger log = Logger.getLogger(DealershipService.class.getName());

    private DealershipDao dealershipDao;
    private ModelDao modelDao;

    public DealershipServiceBean(DealershipDao dealershipDao, ModelDao modelDao) {
        log.info("creating dealership service bean");
        this.dealershipDao = dealershipDao;
        this.modelDao = modelDao;
    }

    @Override
    public Dealership getDealershipById(int id) {
        log.info("searching dealership by id " + id);
        return dealershipDao.findById(id);
    }

    @Override
    public List<Model> getModelsInDealership(Dealership c) {
        log.info("searching models selling in dealership " + c.getId());
        return modelDao.findByDealership(c);
    }

    @Override
    public List<Dealership> getAllDealerships() {
        log.info("searching all dealerships");
        return dealershipDao.findAll();
    }

    @Override
    public List<Dealership> getDealershipByModels(Model m) {
        log.info("searching dealerships by model " + m.getId());
        return dealershipDao.findByModel(m);
    }

}
