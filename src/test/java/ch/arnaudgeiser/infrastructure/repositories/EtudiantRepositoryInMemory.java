package ch.arnaudgeiser.infrastructure.repositories;

import ch.arnaudgeiser.domain.etudiants.Etudiant;
import ch.arnaudgeiser.domain.etudiants.EtudiantRepository;
import ch.arnaudgeiser.domain.etudiants.NoSIUS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EtudiantRepositoryInMemory implements EtudiantRepository {
    private List<Etudiant> etudiantList = new ArrayList<>();

    @Override
    public Optional<Etudiant> find(NoSIUS noSIUS) {
        return etudiantList.stream()
                .filter(e -> e.getNoSIUS().equals(noSIUS))
                .findFirst();
    }

    @Override
    public Etudiant store(Etudiant etudiant) {
        Long newId = etudiantList.stream()
                .map(e -> e.getId())
                .max(Comparator.comparing(e -> e))
                .orElse(1L);

        //etudiant.setId(newId+1);
        etudiantList.add(etudiant);
        return etudiant;
    }

    @Override
    public List<Etudiant> all() {
        return etudiantList;
    }
}
