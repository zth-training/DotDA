package hu.zerotohero.dotda.backend.service.character.calculator;

import hu.zerotohero.dotda.model.character.CharacterVisitor;
import hu.zerotohero.dotda.model.character.NonPlayerCharacter;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.character.Setting;
import lombok.Getter;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class AttackDamageMultiplierCalculator implements CharacterVisitor {

    @Getter
    private double attackDamageMultiplier;

    public void visit(PlayerCharacter playerCharacter) {
        if (playerCharacter.getSetting() == Setting.HARD) {
            attackDamageMultiplier = 1.2;
        } else {
            attackDamageMultiplier = 1.8;
        }
    }

    public void visit(NonPlayerCharacter nonPlayerCharacter) {
        attackDamageMultiplier = 1.5;
    }
}
