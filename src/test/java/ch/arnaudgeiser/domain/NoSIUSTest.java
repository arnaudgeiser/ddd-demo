package ch.arnaudgeiser.domain;

import org.junit.Test;

public class NoSIUSTest {
    @Test(expected = IllegalArgumentException.class)
    public void Given000_ShouldBeInvalid() {
        new NoSIUS("000");
    }
}
