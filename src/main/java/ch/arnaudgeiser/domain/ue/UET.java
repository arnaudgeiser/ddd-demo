package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.domain.etudiants.Semestre;
import ch.arnaudgeiser.domain.ue.CodeUET;
import ch.arnaudgeiser.tags.DDDEntity;

@DDDEntity
public class UET {
    private CodeUET code;
    private Semestre semestre;
}
