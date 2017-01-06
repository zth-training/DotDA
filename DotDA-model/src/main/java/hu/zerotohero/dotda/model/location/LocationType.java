package hu.zerotohero.dotda.model.location;

import hu.zerotohero.dotda.model.attribute.LocationTypeAttribute;
import hu.zerotohero.dotda.model.base.BaseEntity;
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
@EqualsAndHashCode(callSuper = true, exclude = {"actions", "attributes"})
@Entity
@Table(name = "location_type")
public class LocationType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "locationType")
    private List<Action> actions;

    @ManyToMany(mappedBy = "locationTypes")
    private List<LocationTypeAttribute> attributes;
}
