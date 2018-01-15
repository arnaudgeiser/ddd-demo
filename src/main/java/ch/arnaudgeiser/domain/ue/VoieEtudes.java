package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.tags.ValueObject;

@ValueObject
public class VoieEtudes {
    private String value;

    public VoieEtudes(String value) {
        this.value = value;
    }
}
