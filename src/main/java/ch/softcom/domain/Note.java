package ch.softcom.domain;

import ch.softcom.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Note {
    private final int value;

    public Note(int value) {
        this.value = value;
        // Faire en sorte que la note soit supérieure ou égal à 1...
    }
}
