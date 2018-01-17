package ch.arnaudgeiser.domain.ue;

import lombok.Value;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Value
@Embeddable
public class CodeUE {
    @Column(name="CODE_UE")
    private final String value;

    public CodeUE() {
        this.value = null;
    }

    public CodeUE(String value) {
        this.value = value;
    }
}
