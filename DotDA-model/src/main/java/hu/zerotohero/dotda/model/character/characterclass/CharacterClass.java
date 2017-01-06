package hu.zerotohero.dotda.model.character.characterclass;

import hu.zerotohero.dotda.model.attribute.CharacterClassAttribute;
import hu.zerotohero.dotda.model.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Entity
@Table(name = "character_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"attributes"})
@DiscriminatorColumn(name = "discriminator")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CharacterClass extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "characterClass")
    private List<CharacterClassAttribute> attributes;

}
