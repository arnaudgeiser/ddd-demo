package ch.arnaudgeiser.infrastructure.service;

import ch.arnaudgeiser.domain.etudiants.*;
import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.Note;
import ch.arnaudgeiser.domain.ue.UE;
import ch.arnaudgeiser.domain.ue.UERepository;
import ch.arnaudgeiser.infrastructure.state.EntityManagerState;
import ch.arnaudgeiser.domain.common.Error;
import io.vavr.control.Either;
import io.vavr.control.Option;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
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

    public BulletinDeNotes findBulletin(Long id) {
        return inTransaction(() -> {
            BulletinDeNotes bulletinDeNotes = EntityManagerState.getEntityManager().find(BulletinDeNotes.class, id);
            return bulletinDeNotes;
        });
    }

    public BulletinDeNotes saveBulletinNote(BulletinDeNotes bulletinDeNotes) {
        return inTransaction(() -> {
           EntityManagerState.getEntityManager().persist(bulletinDeNotes);
           return bulletinDeNotes;
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

    public Etudiant addNote(NoSIUS noSIUS, CodeUE codeUE, Note note) {
        return inTransaction(() -> {
           Optional<Etudiant> maybeEtudiant = etudiantRepository.find(noSIUS);
           if(!maybeEtudiant.isPresent()) {
               throw new IllegalStateException();
           }
           Etudiant etudiant = maybeEtudiant.get();
           BulletinDeNotes bulletinDeNotes = etudiant.getBulletinDeNotes();
           BulletinDeNotes newBulletinDeNotes = bulletinDeNotes.addResultat(new Resultat(codeUE, note));
           etudiant.setBulletinDeNotes(newBulletinDeNotes);
           return etudiant;
        });
    }
}
