package ch.arnaudgeiser.domain.ue;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {
    @Test(expected = RuntimeException.class)
    public void Note_Given0_ShouldThrowException() {
        new Note(0);
    }
}