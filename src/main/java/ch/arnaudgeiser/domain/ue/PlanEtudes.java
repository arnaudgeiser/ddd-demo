package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.domain.ue.CodeUE;
import ch.arnaudgeiser.tags.DDDEntity;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@DDDEntity
@Embeddable
public class PlanEtudes {
    private String code;
    @Transient
    private final List<CodeUE> codeUEList = new ArrayList<>();

    public PlanEtudes(String code) {
        this.code = code;
    }

    public PlanEtudes() {
        this.code = null;
    }


}
