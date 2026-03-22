package car.repository.jpa;

import car.model.Dealership;
import car.model.Model;
import car.repository.DealershipDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public class JpaDealershipDao implements DealershipDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Dealership> findAll() {
        return entityManager
                .createQuery("select c from Dealership c")
                .getResultList();
    }

    @Override
    public Dealership findById(int id) {
        return entityManager.find(Dealership.class, id);
    }

    @Override
    public List<Dealership> findByModel(Model m) {
        return entityManager
                .createQuery("select c from Dealership inner join c.models model where model=:model")
                .setParameter("model", m)
                .getResultList();
    }

    @Override
    public Dealership save(Dealership dealership) {
        entityManager.persist(dealership);
        return dealership;
    }

}

