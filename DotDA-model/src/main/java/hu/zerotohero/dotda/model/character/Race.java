package hu.zerotohero.dotda.model.character;

import hu.zerotohero.dotda.model.attribute.RaceAttribute;
import hu.zerotohero.dotda.model.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = "attributes")
@Entity
@Table(name = "race")
public class Race extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "playable")
    private Boolean playable;

    @OneToMany(mappedBy = "race")
    private List<RaceAttribute> attributes;

}
