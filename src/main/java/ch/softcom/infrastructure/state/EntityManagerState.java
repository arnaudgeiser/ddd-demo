package ch.softcom.infrastructure.state;

import javax.persistence.EntityManager;

public class EntityManagerState {
    private static final ThreadLocal<EntityManager> state = new ThreadLocal<>();

    public static void setEntityManager(EntityManager em) {
        state.set(em);
    }

    public static EntityManager getEntityManager() {
        return state.get();
    }
}
