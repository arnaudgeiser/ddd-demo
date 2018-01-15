package ch.arnaudgeiser.infrastructure.rest;

import ch.arnaudgeiser.domain.etudiants.AffiliationService;
import ch.arnaudgeiser.domain.etudiants.Etudiant;
import ch.arnaudgeiser.domain.etudiants.NoSIUS;
import ch.arnaudgeiser.domain.common.Error;
import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.PlanEtudes;
import ch.arnaudgeiser.domain.ue.UE;
import ch.arnaudgeiser.infrastructure.service.ApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Either;


import static spark.Spark.get;

public class Endpoint {
    private static ObjectMapper mapper = new ObjectMapper();

    private ApplicationService applicationService;

    public Endpoint(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    public void start() {
        get("/etudiants/all", (req, res) -> {
            return mapper.writeValueAsString(applicationService.allEtudiants());
        });
        get("/etudiants/new/:code/:nom/:prenom", (req, res) -> {
            String code = req.params(":code");
            String nom = req.params(":nom");
            String prenom = req.params(":prenom");

            Etudiant etudiant = new Etudiant(new NoSIUS(code), nom, prenom);
            Either<Error, Etudiant> either = applicationService.saveEtudiant(etudiant);
            if(either.isRight()) {
                return mapper.writeValueAsString(either.get());
            } else {
                return mapper.writeValueAsString(either.getLeft());
            }
        });
        get("/ue/new/:nom/:planEtudes", (req, res) -> {
           String nom = req.params("nom");
           String planEtudes = req.params("planEtudes");

            UE ue = new UE(new CodeUE(nom.substring(0,3).toUpperCase()),nom,new PlanEtudes(planEtudes));
            return mapper.writeValueAsString(applicationService.saveUE(ue));
        });
    }
}
