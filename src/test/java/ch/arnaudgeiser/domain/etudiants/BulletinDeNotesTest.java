package ch.arnaudgeiser.domain.etudiants;

import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.domain.ue.Note;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class BulletinDeNotesTest {
    @Test
    public void bulletinDeNotes() {
        BulletinDeNotes b1 = BulletinDeNotes.empty();
        BulletinDeNotes b2 = BulletinDeNotes.empty();

        assertThat(b1, Matchers.is(b2));
    }

    @Test public void bulletinDeNotes2() {
        BulletinDeNotes b1 = BulletinDeNotes.empty();
        BulletinDeNotes b2 = BulletinDeNotes.empty();

        BulletinDeNotes b3 = b1.addResultat(new Resultat(new CodeUE("123"), new Note(5)));

        assertThat(b1, Matchers.is(b2));
        assertThat(b3.getResultats(), Matchers.contains(new Resultat(new CodeUE("123"), new Note(5))));
    }

    @Test
    public void bulletinDeNotes3() {
        BulletinDeNotes b1 = BulletinDeNotes.empty();
        BulletinDeNotes b3 = b1.addResultat(new Resultat(new CodeUE("123"), new Note(5)));

        assertThat(b3.moyenneByUE(), Matchers.hasEntry(new CodeUE("123"), new Note(5)));
    }
}