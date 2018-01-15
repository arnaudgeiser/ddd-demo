package ch.arnaudgeiser.infrastructure.application;

import ch.arnaudgeiser.domain.etudiants.AffiliationService;
import ch.arnaudgeiser.domain.etudiants.EtudiantRepository;
import ch.arnaudgeiser.domain.ue.UERepository;
import ch.arnaudgeiser.infrastructure.repositories.EtudiantRepositoryJPA;
import ch.arnaudgeiser.infrastructure.repositories.UERepositoryJPA;
import ch.arnaudgeiser.infrastructure.rest.Endpoint;
import ch.arnaudgeiser.infrastructure.service.ApplicationService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DDDApplication {
    public static EntityManagerFactory factory;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EtudiantRepository etudiantRepository = new EtudiantRepositoryJPA();
        UERepository ueRepository = new UERepositoryJPA();
        AffiliationService affiliationService = new AffiliationService(etudiantRepository);
        ApplicationService applicationService = new ApplicationService(emf, etudiantRepository, affiliationService, ueRepository);

        new Endpoint(applicationService).start();
    }
}
