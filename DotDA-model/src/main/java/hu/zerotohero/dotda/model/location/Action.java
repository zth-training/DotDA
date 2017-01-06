package hu.zerotohero.dotda.model.location;

import hu.zerotohero.dotda.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = "locationType")
@Entity
@Table(name = "location")
public class Action extends BaseEntity {

    @Column(name = "type")
    private ActionType actionType;

    @ManyToOne
    @JoinColumn(name = "location_type_id", referencedColumnName = "id")
    private LocationType locationType;

}
