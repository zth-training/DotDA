package hu.zerotohero.dotda.model.character;

import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Entity
@DiscriminatorValue("N")
@EqualsAndHashCode(callSuper = true)
public class NonPlayerCharacter extends Character {

    public void accept(CharacterVisitor characterVisitor) {
        characterVisitor.visit(this);
    }

}
