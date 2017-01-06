package hu.zerotohero.dotda.backend.service.character;

import hu.zerotohero.dotda.model.character.Character;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class DefaultCharacterService implements CharacterService {

    @Override
    public int getHealth(Character character) {
        return 0;
    }

    @Override
    public int getPhysicalDamage(Character character) {
        return 0;
    }

    @Override
    public double getPhysicalDefenseRating(Character character) {
        return 0;
    }

    @Override
    public int getMagicDamage(Character character) {
        return 0;
    }

    @Override
    public double getMagicDefenceRating(Character character) {
        return 0;
    }

    @Override
    public void changeCharacterLocation(Character character) {

    }

}
