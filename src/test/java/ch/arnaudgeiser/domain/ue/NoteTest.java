package ch.arnaudgeiser.domain.ue;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {
    @Test(expected = IllegalArgumentException.class)
    public void GivenNote7_ShouldBeInvalid() {
        new Note(7);
    }

    @Test
    public void GivenNote6_ShouldBeValid() {
        new Note(6);
    }

    @Test
    public void GivenTwoNotesOf6_ShouldBeEqual() {
        assertThat(new Note(6), Matchers.is(new Note(6)));
    }
}