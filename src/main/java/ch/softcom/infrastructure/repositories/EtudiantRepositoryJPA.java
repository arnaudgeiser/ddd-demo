package ch.softcom.infrastructure.repositories;

import ch.softcom.domain.Etudiant;
import ch.softcom.domain.EtudiantRepository;
import ch.softcom.domain.NoSIUS;
import ch.softcom.infrastructure.state.EntityManagerState;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.Connection;
import java.util.Collections;
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
