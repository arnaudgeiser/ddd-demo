package ch.softcom.infrastructure.service;

import ch.softcom.domain.AffiliationService;
import ch.softcom.domain.Etudiant;
import ch.softcom.domain.EtudiantRepository;
import ch.softcom.infrastructure.state.EntityManagerState;
import ch.softcom.infrastructure.rest.Error;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Supplier;

@Service
public class GestionEtudiantService {
    private final EntityManagerFactory emf;
    private final EtudiantRepository etudiantRepository;
    private final AffiliationService affiliationService;

    public GestionEtudiantService(EntityManagerFactory emf, EtudiantRepository etudiantRepository, AffiliationService affiliationService) {
        this.emf = emf;
        this.etudiantRepository = etudiantRepository;
        this.affiliationService = affiliationService;
    }

    public List<Etudiant> allEtudiants() {
        return inTransaction(() -> etudiantRepository.all());
    }

    public Either<Error,Etudiant> saveEtudiant(Etudiant etudiant) {
        return inTransaction(() -> {
           return affiliationService.registerEtudiant(etudiant);
        });
    }

    public <T> T inTransaction(Supplier<T> supplier) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        EntityManagerState.setEntityManager(em);
        T data = supplier.get();
        em.getTransaction().commit();
        return data;
    }


}
