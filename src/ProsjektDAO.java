import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");

    public Prosjekt finnProsjektMedId(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Prosjekt.class, id);
        } finally {
            em.close();
        }
    }

    public void createProsjekt(Prosjekt p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(p);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
