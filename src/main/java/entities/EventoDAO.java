package entities;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event){
        EntityTransaction transaction =em.getTransaction();

        transaction.begin();

        em.persist(event);

        transaction.commit();
        System.err.println("Evento salvato:");
        System.out.println(event);
    }
}