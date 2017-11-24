package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.tags.ValueObject;
import lombok.Value;

import javax.persistence.Embeddable;

@Value
@ValueObject
@Embeddable
public class VersionPE {
    private Long value;

    private VersionPE(Long value) {
        this.value = value;
    }
}
