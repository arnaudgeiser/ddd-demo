package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.ue.PlanEtudes;
import org.intellij.lang.annotations.JdkConstants;

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
    private final Long id = null;
    @Embedded
    @Column(name = "NO_SIUS")
    private NoSIUS noSIUS;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;

    private transient List<Affiliation> affiliations = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    private BulletinDeNotes bulletinDeNotes;

    public Etudiant() {}

    public Etudiant(NoSIUS noSIUS) {
        this.noSIUS = noSIUS;
    }

    public Long getId() {
        return id;
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

    public Etudiant(NoSIUS noSIUS, String nom, String prenom, List<Affiliation> affiliations, BulletinDeNotes bulletinDeNotes) {
        this.noSIUS = noSIUS;
        this.nom = nom;
        this.prenom = prenom;
        this.affiliations = affiliations;
        this.bulletinDeNotes = bulletinDeNotes;
    }

    public Etudiant(NoSIUS noSIUS, String nom, String prenom) {
        this.noSIUS = noSIUS;
        this.nom = nom;
        this.prenom = prenom;
        this.affiliations = new ArrayList<>();
        this.bulletinDeNotes = BulletinDeNotes.empty();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public BulletinDeNotes getBulletinDeNotes() {
        return bulletinDeNotes;
    }

    public void setBulletinDeNotes(BulletinDeNotes bulletinDeNotes) {
        this.bulletinDeNotes = bulletinDeNotes;
    }
}
