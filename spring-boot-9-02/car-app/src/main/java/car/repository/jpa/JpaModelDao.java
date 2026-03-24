package car.repository.jpa;

import car.model.Dealership;
import car.model.Manufacturer;
import car.model.Model;
import car.repository.ModelDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaModelDao implements ModelDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Model> findAll() {
        return entityManager.createQuery(
                "select m from Model m").getResultList();
    }

    @Override
    public Model findById(int id) {return entityManager.find(Model.class, id);}

    @Override
    public List<Model> findByManufacturer(Manufacturer manufact) {
        return entityManager
                .createQuery("select m from Model m where m.manufacturer=:manufacturer")
                .setParameter("manufacturer", manufact)
                .getResultList();
    }

    @Override
    public List<Model> findByDealership(Dealership d) {
        return entityManager.createQuery(
                "select m from Model m inner join m.dealerships dealership where dealership=:dealership")
                .setParameter("dealership", d)
                .getResultList();

    }

    @Override
    public Model add(Model m) {
        entityManager.persist(m);
        return m;
    }
}
