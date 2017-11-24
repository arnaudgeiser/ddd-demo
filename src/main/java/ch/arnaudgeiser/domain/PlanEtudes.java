package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.tags.DDDEntity;

import java.util.ArrayList;
import java.util.List;

@DDDEntity
public class PlanEtudes {
    private final List<CodeUE> codeUEList = new ArrayList<>();
}
