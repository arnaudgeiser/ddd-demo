import ch.arnaudgeiser.infrastructure.repositories.EtudiantRepositoryInMemory;
import ch.arnaudgeiser.domain.common.Error;
import ch.arnaudgeiser.domain.etudiants.AffiliationService;
import ch.arnaudgeiser.domain.etudiants.Etudiant;
import ch.arnaudgeiser.domain.etudiants.EtudiantRepository;
import ch.arnaudgeiser.domain.etudiants.NoSIUS;
import cucumber.api.java8.En;
import io.vavr.control.Either;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BDDSteps implements En {
    private EtudiantRepository etudiantRepository;
    private AffiliationService affiliationService;

    @cucumber.api.java.Before
    public void setUp() {
        etudiantRepository = new EtudiantRepositoryInMemory();
        affiliationService = new AffiliationService(etudiantRepository);
    }


    public BDDSteps() {
        Given("^aucune immatriculation d'étudiant$", () -> {
        });

        When("^l'immatriculation de l'étudiant \"([^\"]*)\" \"([^\"]*)\" avec le No SIUS \"([^\"]*)\"$",
                (String nom, String prenom, String code) -> {
                    Etudiant etudiant = new Etudiant(new NoSIUS(code), nom, prenom);
                    affiliationService.registerEtudiant(etudiant);
        });
        When("^il ne doit pas être possible d'immatriculer l'étudiant \"([^\"]*)\" \"([^\"]*)\" avec le No SIUS \"([^\"]*)\"$",
                (String nom, String prenom, String code) -> {
                Etudiant etudiant = new Etudiant(new NoSIUS(code), nom, prenom);
                    Either<Error, Etudiant> either = affiliationService.registerEtudiant(etudiant);
                    assertEquals(either.isLeft(),true);

                });

        Then("^l'étudiant avec le No SIUS \"([^\"]*)\" doit exister$", (String noSIUS) -> {
            etudiantRepository.find(new NoSIUS(noSIUS));
        });

    }
}
