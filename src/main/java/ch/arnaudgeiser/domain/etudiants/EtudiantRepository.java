package ch.arnaudgeiser.domain.etudiants;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtudiantRepository {
    Optional<Etudiant> find(NoSIUS noSIUS);

    Etudiant store(Etudiant etudiant);

    List<Etudiant> all();
}
