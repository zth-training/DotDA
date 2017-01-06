package hu.zerotohero.dotda.backend.service.character;

import hu.zerotohero.dotda.model.character.Character;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public interface CharacterService {

    int getHealth(Character character);

    int getPhysicalDamage(Character character);

    double getPhysicalDefenseRating(Character character);

    int getMagicDamage(Character character);

    double getMagicDefenceRating(Character character);

    void changeCharacterLocation(Character character);

}
