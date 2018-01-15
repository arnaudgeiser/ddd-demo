package ch.arnaudgeiser.infrastructure.service;

import ch.arnaudgeiser.domain.etudiants.AffiliationService;
import ch.arnaudgeiser.domain.etudiants.Etudiant;
import ch.arnaudgeiser.domain.etudiants.EtudiantRepository;
import ch.arnaudgeiser.domain.ue.UE;
import ch.arnaudgeiser.domain.ue.UERepository;
import ch.arnaudgeiser.infrastructure.state.EntityManagerState;
import ch.arnaudgeiser.domain.common.Error;
import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.function.Supplier;

@Service
public class ApplicationService {
    private final EntityManagerFactory emf;
    private final EtudiantRepository etudiantRepository;
    private final AffiliationService affiliationService;
    private final UERepository ueRepository;

    public ApplicationService(EntityManagerFactory emf, EtudiantRepository etudiantRepository, AffiliationService affiliationService, UERepository ueRepository) {
        this.emf = emf;
        this.etudiantRepository = etudiantRepository;
        this.affiliationService = affiliationService;
        this.ueRepository = ueRepository;
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


    public UE saveUE(UE ue) {
        return inTransaction(() -> {
            return ueRepository.save(ue);
        });
    }
}