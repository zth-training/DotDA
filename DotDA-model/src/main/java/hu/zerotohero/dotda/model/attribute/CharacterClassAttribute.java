package hu.zerotohero.dotda.model.attribute;

import hu.zerotohero.dotda.model.character.characterclass.CharacterClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("C")
@EqualsAndHashCode(callSuper = true, exclude = "characterClass")
public class CharacterClassAttribute extends Attribute {

    @ManyToOne
    @JoinColumn(name = "character_class_id", referencedColumnName = "id")
    private CharacterClass characterClass;

}
