package ch.softcom.domain;

import ch.softcom.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Resultat {
    private final CodeUE codeUE;
    private final Note note;
}
