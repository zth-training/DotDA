package hu.zerotohero.dotda.backend.service.character.calculator;

import hu.zerotohero.dotda.model.attribute.*;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.character.Race;
import hu.zerotohero.dotda.model.character.characterclass.CharacterClass;
import hu.zerotohero.dotda.model.item.Item;
import hu.zerotohero.dotda.model.location.Location;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class CharacterAttributeCalculator {

    public int getAttributeValueByAttributeType(Character character, AttributeType attributeType) {
        return getRaceAttributeValue(character.getRace(), attributeType)
                + getCharacterClassAttributeValue(character.getCharacterClass(), attributeType)
                + getItemAttributeValue(character.getInventory(), attributeType)
                + getLocationAttributeValue(character.getLocation(), attributeType);
    }

    private int getRaceAttributeValue(Race race, AttributeType attributeType) {
        int attributeValue = 0;

        List<RaceAttribute> attributes = race.getAttributes();
        int i = 0;
        while (i < attributes.size()) {
            RaceAttribute raceAttribute = attributes.get(i);
            if (raceAttribute.getAttributeType() == attributeType) {
                attributeValue += raceAttribute.getValue();
                break;
            }
            i++;
        }
        return attributeValue;
    }

    private int getCharacterClassAttributeValue(CharacterClass characterClass, AttributeType attributeType) {
        int attributeValue = 0;

        List<CharacterClassAttribute> attributes = characterClass.getAttributes();

        for (int i = 0; i < attributes.size(); i++) {
            CharacterClassAttribute characterClassAttribute = attributes.get(i);

            if (characterClassAttribute.getAttributeType() == attributeType) {
                attributeValue += characterClassAttribute.getValue();
                break;
            }
        }

        return attributeValue;
    }

    private int getItemAttributeValue(List<Item> items, AttributeType attributeType) {
        int attributeValue = 0;

        for (Item item : items) {
            for (ItemAttribute itemAttribute : item.getAttributes()) {
                if (itemAttribute.getAttributeType() == attributeType) {
                    attributeValue += itemAttribute.getValue();
                    break;
                }
            }
        }
        return attributeValue;
    }

    private int getLocationAttributeValue(Location location, AttributeType attributeType) {
        int attributeValue = 0;

        for (Iterator<LocationTypeAttribute> iterator = location.getLocationType().getAttributes().iterator(); iterator.hasNext(); ) {
            LocationTypeAttribute locationTypeAttribute = iterator.next();

            if (locationTypeAttribute.getAttributeType() == attributeType) {
                attributeValue += locationTypeAttribute.getValue();
            }
        }

        return attributeValue;
    }
}
