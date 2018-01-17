package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.common.IdentifiedValueObject;
import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.Note;
import ch.arnaudgeiser.domain.ue.PlanEtudes;
import ch.arnaudgeiser.tags.ValueObject;
import lombok.Data;
import lombok.Value;
import org.h2.result.ResultTarget;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

@Entity
@Table(name="BULLETIN_DE_NOTES")
@ValueObject
@Data
@Access(AccessType.FIELD)
public class BulletinDeNotes extends IdentifiedValueObject {
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_BULLETIN_DE_NOTES")
    private final List<Resultat> resultats;

    private BulletinDeNotes() {
        this(Collections.emptyList());
    }

    public BulletinDeNotes(List<Resultat> resultats) {
        this.resultats = resultats;
    }

    public static BulletinDeNotes empty() {
        return new BulletinDeNotes(Collections.emptyList());
    }

    public Map<CodeUE, Note> moyenneByUE() {
        return resultats.stream()
                .collect(groupingBy(Resultat::getCodeUE, mapping(Resultat::getNote,
                        collectingAndThen(averagingInt(n -> n.getValue()), n -> Note.valueOf(n.intValue())))));
    }

    public BulletinDeNotes addResultat(Resultat resultat) {
        return new BulletinDeNotes(Stream.concat(Stream.of(resultat),resultats.stream()).collect(Collectors.toList()));
    }
}
