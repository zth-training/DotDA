package hu.zerotohero.dotda.model.attribute;

import hu.zerotohero.dotda.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Entity
@Table(name = "attribute")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name = "discriminator")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Attribute extends BaseEntity {

    @Column(name = "type")
    private AttributeType attributeType;

    @Column(name = "value")
    private Integer value;
}
