package hu.zerotohero.dotda.backend.service.battle;

import hu.zerotohero.dotda.backend.service.action.ActionService;
import hu.zerotohero.dotda.backend.service.character.CharacterService;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.character.CharacterDao;
import hu.zerotohero.dotda.model.character.NonPlayerCharacter;
import hu.zerotohero.dotda.model.location.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Getter
@NoArgsConstructor
public class BattleService {

    private Character attacker;
    private Character defender;
    private Location location;

    private int attackerCurrentHealth;
    private int defenderCurrentHealth;

    private CharacterDao characterDao;
    private BaseDao baseDao;

    private CharacterService characterService;
    private ActionService actionService;

    public BattleService(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public BattleService(Character attacker, Character defender, Location location, CharacterService characterService, ActionService actionService, CharacterDao characterDao, BaseDao baseDao) {
        this.attacker = attacker;
        this.defender = defender;
        this.location = location;
        this.characterService = characterService;
        this.actionService = actionService;
        this.characterDao = characterDao;
        this.baseDao = baseDao;

        attackerCurrentHealth = characterService.getHealth(attacker);
        defenderCurrentHealth = characterService.getHealth(defender);
    }

    public void attack(Character attacker, String modifier) {
        if (attacker.equals(this.attacker)) {
            defenderCurrentHealth = actionService.attack(this.attacker, defender, defenderCurrentHealth, modifier);
        } else {
            attackerCurrentHealth = actionService.attack(defender, this.attacker, attackerCurrentHealth, modifier);
        }
    }

    public Character getWinner() {
        if (defenderCurrentHealth <= 0 && attackerCurrentHealth > 0) {
            return attacker;
        } else if (attackerCurrentHealth <= 0 && defenderCurrentHealth > 0) {
            return defender;
        } else {
            return null;
        }
    }

    public void transferPriceToWinner(Character winner, Character looser) {
        PriceDistributor priceDistributor = new PriceDistributor(looser, characterDao);
        winner.accept(priceDistributor);
    }

    public NonPlayerCharacter getEnemy() {
        return (NonPlayerCharacter) baseDao.findAll(NonPlayerCharacter.class)
                .get((int) Math.round((new Random().nextDouble()) * 3));
    }

}
