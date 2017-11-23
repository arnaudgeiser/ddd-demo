package ch.softcom.domain;

import ch.softcom.tags.ValueObject;

@ValueObject
public class VoieEtudes {
    private String value;

    public VoieEtudes(String value) {
        this.value = value;
    }
}
