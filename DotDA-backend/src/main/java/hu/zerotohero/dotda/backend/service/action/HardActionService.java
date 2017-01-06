package hu.zerotohero.dotda.backend.service.action;

import org.springframework.transaction.annotation.Transactional;
import hu.zerotohero.dotda.backend.service.character.calculator.CharacterAttributeCalculator;
import hu.zerotohero.dotda.backend.service.character.HardCharacterService;
import hu.zerotohero.dotda.backend.service.character.calculator.PriceMultiplierCalculator;
import hu.zerotohero.dotda.model.character.CharacterDao;
import hu.zerotohero.dotda.model.item.ItemDao;
import hu.zerotohero.dotda.model.attribute.AttributeType;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.item.Item;
import hu.zerotohero.dotda.model.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class HardActionService implements ActionService {

    private static final int BASE_SEARCH_CURRENCY = 50;

    @Autowired
    private HardCharacterService hardCharacterService;

    @Autowired
    private CharacterDao characterDao;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CharacterAttributeCalculator characterAttributeCalculator;

    public int attack(Character attacker, Character defender, int currentHealth, String modifier) {
        int attackDamage = 0;

        switch (modifier) {
            case "physical": {
                attackDamage = getPhysicalDamage(attacker, defender);
                break;
            }
            case "magical": {
                attackDamage = getMagicDamage(attacker, defender);
                break;
            }
        }

        return currentHealth - attackDamage;
    }

    @Transactional
    public void trade(Character seller, Character buyer, Item item) {

        int price = (int) Math.round(getPriceMultiplier(buyer) * item.getValue());

        if (buyer.getCurrency() > price) {
            itemDao.transferItem(buyer, seller, item);
            characterDao.changeCharacterCurrency(seller, price);
            characterDao.changeCharacterCurrency(buyer, (-1 * price));
        }

    }

    public void search(Character character) {
        characterDao.changeCharacterCurrency(character, getFoundCurrency(character));
    }

    public void travel(Character traveler, Location goal) {
        characterDao.changeCharacterLocation(traveler, goal);
    }

    private double getPriceMultiplier(Character buyer) {

        PriceMultiplierCalculator priceMultiplierCalculator = new PriceMultiplierCalculator();
        buyer.accept(priceMultiplierCalculator);

        return priceMultiplierCalculator.getPriceMultiplier();
    }

    private int getFoundCurrency(Character character) {

        Random random = new Random();

        return (int) Math.round((characterAttributeCalculator.getAttributeValueByAttributeType(character, AttributeType.INTELLIGENCE)
                + BASE_SEARCH_CURRENCY) * random.nextDouble());
    }

    private int getPhysicalDamage(Character attacker, Character defender) {
        return (int) Math.round(hardCharacterService.getPhysicalDamage(attacker) * (1 - hardCharacterService.getPhysicalDefenseRating(defender)));
    }

    private int getMagicDamage(Character attacker, Character defender) {
        return (int) Math.round(hardCharacterService.getMagicDamage(attacker) * (1 - hardCharacterService.getMagicDefenceRating(defender)));
    }

}
