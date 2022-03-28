import javax.persistence.*;

public class AvdelingDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");

    public Avdeling finnAvdelingMedId(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Avdeling.class, id);
        } finally {
            em.close();
        }
    }

    public Avdeling finnAvdelingMedNavn(String Navn) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Avdeling> query = em.createQuery("SELECT a FROM Avdeling a WHERE a.navn LIKE :Navn", Avdeling.class);
            query.setParameter("Navn", Navn);

            return query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public void createAvdeling(Avdeling a) {
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

}