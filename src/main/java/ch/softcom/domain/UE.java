package ch.softcom.domain;

import ch.softcom.tags.Aggregate;
import ch.softcom.tags.DDDEntity;

import java.util.List;

@Aggregate
@DDDEntity
public class UE {
    private CodeUE code;
    private List<UET> uetList;
}
