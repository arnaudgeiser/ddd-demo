package ch.arnaudgeiser.domain.ue;

import lombok.Value;

import javax.persistence.Access;

@Value
public class CodeUE {
    private final String value;

    public CodeUE() {
        this.value = null;
    }

    public CodeUE(String value) {
        this.value = value;
    }
}
