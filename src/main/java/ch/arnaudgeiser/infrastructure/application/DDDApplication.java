package ch.arnaudgeiser.infrastructure.application;

import ch.arnaudgeiser.domain.AffiliationService;
import ch.arnaudgeiser.domain.EtudiantRepository;
import ch.arnaudgeiser.infrastructure.repositories.EtudiantRepositoryJPA;
import ch.arnaudgeiser.infrastructure.rest.Endpoint;
import ch.arnaudgeiser.infrastructure.service.GestionEtudiantService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DDDApplication {
    public static EntityManagerFactory factory;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EtudiantRepository etudiantRepository = new EtudiantRepositoryJPA();
        AffiliationService affiliationService = new AffiliationService(etudiantRepository);
        GestionEtudiantService gestionEtudiantService = new GestionEtudiantService(emf, etudiantRepository, affiliationService);

        new Endpoint(gestionEtudiantService, affiliationService).start();
    }
}
