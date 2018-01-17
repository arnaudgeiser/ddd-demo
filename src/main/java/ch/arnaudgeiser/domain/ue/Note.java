package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@ValueObject
@Value
@Embeddable
public class Note {
    @Column(name="NOTE")
    private final int value;

    private Note() {
        value = -1;
    }

    public Note(int value) {
        if(value < 1 || value > 6) {
            throw new RuntimeException();
        }

        this.value = value;
    }

    public static Note valueOf(int value) {
        return new Note(value);
    }
}
