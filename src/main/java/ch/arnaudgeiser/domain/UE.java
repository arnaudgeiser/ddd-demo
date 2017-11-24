package ch.arnaudgeiser.domain;

import ch.arnaudgeiser.tags.Aggregate;
import ch.arnaudgeiser.tags.DDDEntity;

import java.util.List;

@Aggregate
@DDDEntity
public class UE {
    private CodeUE code;
    private List<UET> uetList;
}
