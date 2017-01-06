package hu.zerotohero.dotda.model.base;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    public BaseEntity() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
