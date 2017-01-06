package hu.zerotohero.dotda.backend.service.character;

import hu.zerotohero.dotda.backend.service.character.calculator.AttackDamageMultiplierCalculator;
import hu.zerotohero.dotda.backend.service.character.calculator.CharacterAttributeCalculator;
import hu.zerotohero.dotda.backend.service.character.calculator.DefenseRatingMultiplierCalculator;
import hu.zerotohero.dotda.model.attribute.AttributeType;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.character.CharacterDao;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class HardCharacterService implements CharacterService {

    @Autowired
    private CharacterAttributeCalculator characterAttributeCalculator;

    @Autowired
    private CharacterDao characterDao;

    @Autowired
    private BaseDao baseDao;

    @Override
    public int getHealth(Character character) {
        return characterAttributeCalculator.getAttributeValueByAttributeType(character, AttributeType.HEALTH);
    }

    @Override
    public int getPhysicalDamage(Character character) {
        return getDamage(character, AttributeType.STRENGTH);
    }

    @Override
    public double getPhysicalDefenseRating(Character character) {
        return getRating(character, AttributeType.AGILITY);
    }

    @Override
    public int getMagicDamage(Character character) {
        return getDamage(character, AttributeType.INTELLIGENCE);
    }

    @Override
    public double getMagicDefenceRating(Character character) {
        return getRating(character, AttributeType.WISDOM);
    }

    @Override
    @Transactional
    public void changeCharacterLocation(Character character) {
        List<Location> locations = baseDao.findAll(Location.class);
        if (character.getLocation().getLocationType().getName().equals("city")) {
            Location goal = locations.stream().filter(location -> location.getLocationType().getName().equals("swamp")).collect(Collectors.toList()).get(0);
            characterDao.changeCharacterLocation(character, goal);
        } else {
            Location goal = locations.stream().filter(location -> location.getLocationType().getName().equals("city")).collect(Collectors.toList()).get(0);
            characterDao.changeCharacterLocation(character, goal);
        }
    }

    public PlayerCharacter getPlayerCharacterByName(String characterName) {
        return (PlayerCharacter) characterDao.findCharacter(characterName);
    }

    private int getDamage(Character character, AttributeType attributeType) {
        AttackDamageMultiplierCalculator attackDamageMultiplierCalculator = new AttackDamageMultiplierCalculator();
        character.accept(attackDamageMultiplierCalculator);

        return (int) Math.round(
                characterAttributeCalculator.getAttributeValueByAttributeType(character, attributeType)
                        * attackDamageMultiplierCalculator.getAttackDamageMultiplier()
        );
    }

    private double getRating(Character character, AttributeType attributeType) {
        DefenseRatingMultiplierCalculator defenseRatingMultiplierCalculator = new DefenseRatingMultiplierCalculator();
        character.accept(defenseRatingMultiplierCalculator);

        return characterAttributeCalculator.getAttributeValueByAttributeType(character, attributeType)
                * defenseRatingMultiplierCalculator.getDefenseRatingMultiplier();
    }

}
