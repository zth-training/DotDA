package hu.zerotohero.dotda.backend.service.character.calculator;

import hu.zerotohero.dotda.model.character.CharacterVisitor;
import hu.zerotohero.dotda.model.character.NonPlayerCharacter;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.character.Setting;
import lombok.Getter;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class PriceMultiplierCalculator implements CharacterVisitor {

    @Getter
    private double priceMultiplier;

    public void visit(PlayerCharacter playerCharacter) {
        if (playerCharacter.getSetting() == Setting.HARD){
            priceMultiplier = 0.4;
        } else {
            priceMultiplier = 0.8;
        }
    }

    public void visit(NonPlayerCharacter nonPlayerCharacter) {
        priceMultiplier = 1.5;
    }
}
