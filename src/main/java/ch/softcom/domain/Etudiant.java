package ch.softcom.domain;

import ch.softcom.tags.Aggregate;
import ch.softcom.tags.DDDEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ETUDIANTS")
@Access(AccessType.FIELD)
public class Etudiant {
    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    @Column(name = "NO_SIUS")
    private NoSIUS noSIUS;
    private transient List<Affiliation> affiliations = new ArrayList<>();

    private transient BulletinDeNotes bulletinDeNotes;

    public Etudiant() {}

    public Etudiant(NoSIUS noSIUS) {
        this.noSIUS = noSIUS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void affiliate(Affiliation affiliation) {
        affiliations.add(affiliation);
    }

    public NoSIUS getNoSIUS() {
        return noSIUS;
    }

    public void setNoSIUS(NoSIUS noSIUS) {
        this.noSIUS = noSIUS;
    }

    public List<Affiliation> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<Affiliation> affiliations) {
        this.affiliations = affiliations;
    }

    public boolean hasAlreadyAffiliationVoieEtudes(List<Affiliation> affiliations, PlanEtudes planEtudes) {
        return affiliations.stream().anyMatch(p -> p.equals(planEtudes));
    }
}
