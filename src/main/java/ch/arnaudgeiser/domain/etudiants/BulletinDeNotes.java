package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.Note;
import ch.arnaudgeiser.domain.ue.PlanEtudes;
import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;
import org.h2.result.ResultTarget;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
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
    private List<Resultat> resultats;

    public static BulletinDeNotes empty() {
        return new BulletinDeNotes(null, Collections.emptyList());
    }

    public Map<CodeUE, Note> moyenneByUE() {
        return resultats.stream()
                .collect(groupingBy(Resultat::getCodeUE,
                        mapping(Resultat::getNote,collectingAndThen(
                                averagingInt(Note::getValue),v -> Note.valueOf(v.intValue())))));
    }

    public BulletinDeNotes addResultat(Resultat resultat) {
        return new BulletinDeNotes(this.id, Stream.concat(Stream.of(resultat),resultats.stream()).collect(Collectors.toList()));
    }
}
