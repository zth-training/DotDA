package hu.zerotohero.dotda.backend.service.character.calculator;

import hu.zerotohero.dotda.model.character.CharacterVisitor;
import hu.zerotohero.dotda.model.character.NonPlayerCharacter;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.character.Setting;
import lombok.Getter;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class DefenseRatingMultiplierCalculator implements CharacterVisitor {

    @Getter
    private double defenseRatingMultiplier;

    public void visit(PlayerCharacter playerCharacter) {
        if (playerCharacter.getSetting() == Setting.HARD){
            defenseRatingMultiplier = 0.01;
        } else {
            defenseRatingMultiplier = 0.03;
        }
    }

    public void visit(NonPlayerCharacter nonPlayerCharacter) {
        defenseRatingMultiplier = 0.02;
    }
}
