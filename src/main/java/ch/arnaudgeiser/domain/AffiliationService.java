package ch.arnaudgeiser.domain;

import io.vavr.control.Either;
import org.springframework.stereotype.Service;

import ch.arnaudgeiser.infrastructure.rest.Error;

import java.util.Optional;

@Service
public class AffiliationService {
    private final EtudiantRepository etudiantRepository;

    public AffiliationService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public Either<Error, Etudiant> registerEtudiant(Etudiant etudiant) {
        Optional<Etudiant> maybeEtudiant = etudiantRepository.find(etudiant.getNoSIUS());
        if(maybeEtudiant.isPresent()) {
            return Either.left(new Error("Déjà existant"));
        } else {
            return Either.right(etudiantRepository.store(etudiant));
        }
    }
}
