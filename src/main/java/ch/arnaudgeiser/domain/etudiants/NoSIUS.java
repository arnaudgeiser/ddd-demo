package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.tags.ValueObject;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ValueObject
@Embeddable
public final class NoSIUS {

    private final String value;

    public NoSIUS() {
        this.value = null;
    }

    public NoSIUS(String value) {
        Pattern p = Pattern.compile("[0-9]{4}-[0-9]{2}");
        Matcher m = p.matcher(value);


        if(!m.matches()) {
            throw new IllegalArgumentException("Invalid SIUS number : " + value);
        }

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoSIUS noSIUS = (NoSIUS) o;

        return value != null ? value.equals(noSIUS.value) : noSIUS.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public String getValue() {
        return value;
    }
}
