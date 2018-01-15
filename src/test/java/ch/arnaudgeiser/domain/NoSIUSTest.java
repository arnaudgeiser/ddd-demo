package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.domain.etudiants.NoSIUS;
import org.junit.Test;

public class NoSIUSTest {
    @Test(expected = IllegalArgumentException.class)
    public void Given000_ShouldBeInvalid() {
        new NoSIUS("000");
    }
}
