package ch.arnaudgeiser.infrastructure.repositories;

import ch.arnaudgeiser.domain.ue.UE;
import ch.arnaudgeiser.domain.ue.UERepository;
import ch.arnaudgeiser.infrastructure.state.EntityManagerState;

public class UERepositoryJPA implements UERepository {
    @Override
    public UE save(UE ue) {
        EntityManagerState.getEntityManager().persist(ue);
        return ue;
    }
}
