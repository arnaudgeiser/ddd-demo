package ch.arnaudgeiser.domain;

import lombok.Value;

import java.util.regex.Pattern;

@Value
public class Semestre {
    private String semestre;

    private static final Pattern pattern = Pattern.compile("S[AP]-[0-9]{4}");

    private Semestre(String semestre) {
        if(pattern.matcher(semestre).matches()) {
            throw new IllegalArgumentException();
        }
        this.semestre = semestre;
    }
}
