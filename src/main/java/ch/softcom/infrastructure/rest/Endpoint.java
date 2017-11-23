package ch.softcom.infrastructure.rest;

import ch.softcom.domain.Affiliation;
import ch.softcom.domain.AffiliationService;
import ch.softcom.domain.Etudiant;
import ch.softcom.domain.NoSIUS;
import ch.softcom.infrastructure.rest.Error;
import ch.softcom.infrastructure.service.GestionEtudiantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Either;


import static spark.Spark.get;

public class Endpoint {
    private static ObjectMapper mapper = new ObjectMapper();

    private GestionEtudiantService gestionEtudiantService;
    private AffiliationService affiliationService;

    public Endpoint(GestionEtudiantService gestionEtudiantService, AffiliationService affiliationService) {
        this.gestionEtudiantService= gestionEtudiantService;
        this.affiliationService = affiliationService;
    }

    public void start() {
        get("/parcelles", (req, res) -> {
            return "TEST";
        });
        get("/all", (req, res) -> {
            return mapper.writeValueAsString(gestionEtudiantService.allEtudiants());
        });
        get("/new", (req, res) -> {
            Etudiant etudiant = new Etudiant(new NoSIUS("1234-12"));
            Either<Error, Etudiant> either = gestionEtudiantService.saveEtudiant(etudiant);
            if(either.isRight()) {
                return mapper.writeValueAsString(either.get());
            } else {
                return mapper.writeValueAsString(either.getLeft());
            }
        });
    }
}
