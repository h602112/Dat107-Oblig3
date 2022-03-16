import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AnsattDAO {

    private EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("ansattPersistenceUnit");



    public Ansatt finnAnsattMedPk(String brukernavn) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, brukernavn);
        } finally {
            em.close();
        }
    }

    public List<Ansatt> finnAlleAnsatte() {

        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Ansatt> query = em.createQuery("select a from Ansatt a", Ansatt.class);

            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
