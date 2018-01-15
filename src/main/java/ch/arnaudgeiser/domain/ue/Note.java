package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

@ValueObject
@Value
public class Note {
    private final int value;

    public Note(int value) {
        if(value < 1 || value > 6) {
            throw new RuntimeException("Test");
        }

        this.value = value;
    }

    public static Note valueOf(int value) {
        return new Note(value);
    }
}
