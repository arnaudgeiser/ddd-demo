package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Resultat {
    private final CodeUE codeUE;
    private final Note note;
}
