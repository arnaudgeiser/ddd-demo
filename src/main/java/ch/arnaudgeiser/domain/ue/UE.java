package ch.arnaudgeiser.domain.ue;

import ch.arnaudgeiser.tags.Aggregate;
import ch.arnaudgeiser.tags.DDDEntity;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;
import java.util.List;

@Aggregate
@DDDEntity
@Entity
@Table(name="UE")
@Access(AccessType.FIELD)
@Data
public class UE {
    @Id
    @Column(name= "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    @Column(name = "CODE")
    @JsonUnwrapped
    private CodeUE code;
    @Column(name = "NOM")
    private String nom;
    @Transient
    private transient List<UET> uetList;
    @Embedded
    @Column(name = "PLAN_ETUDES")
    private PlanEtudes planEtudes;

    public UE(CodeUE code, String nom, PlanEtudes planEtudes) {
        this.code = code;
        this.nom = nom;
        this.planEtudes = planEtudes;
    }
}
