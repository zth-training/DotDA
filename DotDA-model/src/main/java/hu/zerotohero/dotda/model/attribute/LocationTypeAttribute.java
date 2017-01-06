package hu.zerotohero.dotda.model.attribute;

import hu.zerotohero.dotda.model.location.LocationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("L")
@EqualsAndHashCode(callSuper = true, exclude = "locationTypes")
public class LocationTypeAttribute extends Attribute {

    @ManyToMany
    @JoinTable(name = "attributes_to_location_types",
            joinColumns = @JoinColumn(name = "attribute_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "location_type_id", referencedColumnName = "id"))
    private List<LocationType> locationTypes;
}
