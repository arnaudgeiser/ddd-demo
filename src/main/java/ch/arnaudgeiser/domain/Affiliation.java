package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.tags.ValueObject;

import java.time.LocalDate;

@ValueObject
public class Affiliation {
    private final VoieEtudes voieEtudes;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;
    private final StatutAffiliation statut;

    public Affiliation(VoieEtudes voieEtudes, LocalDate dateDebut, LocalDate dateFin, StatutAffiliation statut) {
        this.voieEtudes = voieEtudes;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public VoieEtudes getVoieEtudes() {
        return voieEtudes;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Affiliation that = (Affiliation) o;

        if (voieEtudes != null ? !voieEtudes.equals(that.voieEtudes) : that.voieEtudes != null) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;
        return statut == that.statut;
    }

    @Override
    public int hashCode() {
        int result = voieEtudes != null ? voieEtudes.hashCode() : 0;
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        return result;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public StatutAffiliation getStatut() {
        return statut;
    }
}
