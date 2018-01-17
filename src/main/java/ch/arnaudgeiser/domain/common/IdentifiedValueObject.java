package ch.arnaudgeiser.domain.common;

import javax.persistence.*;

@MappedSuperclass
public class IdentifiedValueObject {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
