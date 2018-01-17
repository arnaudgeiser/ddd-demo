package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.common.IdentifiedValueObject;
import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.Note;
import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@ValueObject
@Value
@Entity
@Table(name = "RESULTATS")
public class Resultat extends IdentifiedValueObject {
    @Embedded
    private final CodeUE codeUE;
    @Embedded
    private final Note note;

    @Column(name="FK_BULLETIN_DE_NOTES")
    private Long bulletinDeNotesId = null;

    public Resultat() {
        this(null, null);
    }

    public Resultat(CodeUE codeUE, Note note) {
        this.codeUE = codeUE;
        this.note = note;
    }

    public int getNoteAsInt() {
      return note.getValue();
    }
}