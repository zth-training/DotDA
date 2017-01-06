package hu.zerotohero.dotda.model.character.characterclass;

import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Entity
@DiscriminatorValue("N")
@EqualsAndHashCode(callSuper = true)
public class NonPlayableCharacterClass extends CharacterClass {
}
