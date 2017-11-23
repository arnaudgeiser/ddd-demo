package ch.softcom.domain;

import ch.softcom.tags.ValueObject;
import lombok.Value;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

@Entity
@Table(name="BULLETIN_DE_NOTES")
@Value
@ValueObject
public class BulletinDeNotes {
    @Id
    @GeneratedValue
    private Long id;
    private PlanEtudes planEtudes;
    private List<Resultat> resultats;

    public Map<CodeUE, BigDecimal> moyenneByUE() {
        return resultats.stream()
                .collect(groupingBy(Resultat::getCodeUE,
                        mapping(Resultat::getNote,collectingAndThen(
                                averagingInt(Note::getValue),BigDecimal::valueOf))));
    }

    public BulletinDeNotes addResultat(Resultat resultat) {
        return new BulletinDeNotes(this.id, this.planEtudes, Stream.concat(Stream.of(resultat),resultats.stream()).collect(Collectors.toList()));
    }
}
