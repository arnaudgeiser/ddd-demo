package ch.softcom.infrastructure.application;

import ch.softcom.domain.AffiliationService;
import ch.softcom.domain.EtudiantRepository;
import ch.softcom.infrastructure.repositories.EtudiantRepositoryJPA;
import ch.softcom.infrastructure.rest.Endpoint;
import ch.softcom.infrastructure.service.GestionEtudiantService;

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
