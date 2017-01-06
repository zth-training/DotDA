package hu.zerotohero.dotda.model.character;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public interface CharacterVisitor {

    void visit (PlayerCharacter playerCharacter);

    void visit (NonPlayerCharacter nonPlayerCharacter);

}
