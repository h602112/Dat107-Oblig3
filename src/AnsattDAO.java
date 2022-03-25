import javax.persistence.*;
import java.util.List;

public class AnsattDAO {

    private EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("ansattPersistenceUnit");




    public void createAnsatt(Ansatt a) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(a);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }

    }


    public Ansatt finnAnsattMedId(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
    }
    public Ansatt finnAnsattMedBrukerNavn(String brukerNavn) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Ansatt> query = em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn LIKE :brukerNavn", Ansatt.class);
            query.setParameter("brukerNavn", brukerNavn);

            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Ansatt> hentAlleAnsatte() {

        EntityManager em = emf.createEntityManager();

        List<Ansatt> ansatte = null;
        try {
            TypedQuery<Ansatt> query = em.createNamedQuery("hentAlleAnsatte", Ansatt.class);
            ansatte = query.getResultList();
        } finally {
            em.close();
        }
        return ansatte;
    }

    public void updateAnsattLonn(int id, int nyLonn) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Ansatt a = em.find(Ansatt.class, id);
            a.setMaanedslonn(nyLonn);

            em.getTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public void updateAnsattStilling(int id, String nyStilling) {

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Ansatt a = em.find(Ansatt.class, id);
            a.setStilling(nyStilling);

            em.getTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
            em.getTransaction().rollback();
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
