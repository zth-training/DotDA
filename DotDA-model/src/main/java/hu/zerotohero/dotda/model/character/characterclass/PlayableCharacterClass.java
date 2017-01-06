package hu.zerotohero.dotda.model.character.characterclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@Entity
@DiscriminatorValue("P")
@EqualsAndHashCode(callSuper = true)
public class PlayableCharacterClass extends CharacterClass {
}
