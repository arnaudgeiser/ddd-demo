package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.common.Error;
import ch.arnaudgeiser.infrastructure.repositories.EtudiantRepositoryInMemory;
import io.vavr.control.Either;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AffiliationServiceTest {
    private EtudiantRepository etudiantRepository;


    @Before
    public void setUp() {
        etudiantRepository = new EtudiantRepositoryInMemory();
    }

    @Test
    public void test() {
        AffiliationService affiliationService = new AffiliationService(etudiantRepository);

        Etudiant etudiant = new Etudiant();
        etudiant.setNoSIUS(new NoSIUS("1111-12"));
        affiliationService.registerEtudiant(etudiant);


        Etudiant etudiant2 = new Etudiant();
        etudiant2.setNoSIUS(new NoSIUS("1111-12"));
        Either<Error, Etudiant> result = affiliationService.registerEtudiant(etudiant2);

        assertThat(result.isLeft(), Matchers.is(true));
    }

}