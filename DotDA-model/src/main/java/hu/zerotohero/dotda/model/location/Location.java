package hu.zerotohero.dotda.model.location;

import hu.zerotohero.dotda.model.base.BaseEntity;
import hu.zerotohero.dotda.model.character.Character;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = {"locationType", "characters"})
@Entity
@Table(name = "location")
public class Location extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_type_id", referencedColumnName = "id")
    private LocationType locationType;

    @OneToMany(mappedBy = "location")
    private List<Character> characters;

}
