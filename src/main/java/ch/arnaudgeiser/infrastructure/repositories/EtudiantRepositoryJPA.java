package ch.arnaudgeiser.infrastructure.repositories;

import ch.arnaudgeiser.domain.etudiants.Etudiant;
import ch.arnaudgeiser.domain.etudiants.EtudiantRepository;
import ch.arnaudgeiser.domain.etudiants.NoSIUS;
import ch.arnaudgeiser.infrastructure.state.EntityManagerState;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class EtudiantRepositoryJPA implements EtudiantRepository {

    @Override
    public Optional<Etudiant> find(NoSIUS noSIUS) {
        Query query = EntityManagerState.getEntityManager().createQuery("SELECT e FROM Etudiant AS e WHERE e.noSIUS=:noSIUS");
        query.setParameter("noSIUS",noSIUS);
        return query.getResultList().stream().map(Etudiant.class::cast).findFirst();
    }

    @Override
    public Etudiant store(Etudiant etudiant) {
        EntityManagerState.getEntityManager().persist(etudiant);
        return etudiant;

    }

    @Override
    public List<Etudiant> all() {
        return EntityManagerState.getEntityManager().createQuery("SELECT e FROM Etudiant AS  e").getResultList();
    }
}
