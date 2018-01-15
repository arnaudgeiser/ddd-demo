package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.Note;
import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Resultat {
    private final CodeUE codeUE;
    private final Note note;
}
