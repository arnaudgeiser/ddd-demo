package ch.softcom.domain;

import ch.softcom.tags.ValueObject;
import lombok.Value;
import sun.misc.Version;

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
