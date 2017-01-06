package hu.zerotohero.dotda.frontend.ui.character;

import hu.zerotohero.dotda.backend.service.character.HardCharacterService;
import hu.zerotohero.dotda.backend.service.character.calculator.CharacterAttributeCalculator;
import hu.zerotohero.dotda.model.attribute.AttributeType;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.context.AppCtx;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class CharacterControllerBean {

    public PlayerCharacter getSelectedCharacter(String characterName) {
        return AppCtx.bean(HardCharacterService.class).getPlayerCharacterByName(characterName);
    }

    public Object[] mapCharacterToTables(PlayerCharacter playerCharacter) {
        CharacterAttributeCalculator characterAttributeCalculator = AppCtx.bean(CharacterAttributeCalculator.class);

        return new Object[]{
                playerCharacter.getName(),
                playerCharacter.getCharacterClass().getName(),
                characterAttributeCalculator.getAttributeValueByAttributeType(playerCharacter, AttributeType.STRENGTH),
                characterAttributeCalculator.getAttributeValueByAttributeType(playerCharacter, AttributeType.AGILITY),
                characterAttributeCalculator.getAttributeValueByAttributeType(playerCharacter, AttributeType.INTELLIGENCE),
                characterAttributeCalculator.getAttributeValueByAttributeType(playerCharacter, AttributeType.WISDOM)};
    }

    public List<Object[]> mapCharacterListToTables(List<PlayerCharacter> playerCharacters) {
        List<Object[]> mappedCharacters = new ArrayList<>();

        for (PlayerCharacter playerCharacter : playerCharacters) {
            mappedCharacters.add(mapCharacterToTables(playerCharacter));
        }
        return mappedCharacters;
    }
}
