package hu.zerotohero.dotda.backend.service.action;

import org.springframework.transaction.annotation.Transactional;
import hu.zerotohero.dotda.backend.service.character.DefaultCharacterService;
import hu.zerotohero.dotda.model.item.ItemDao;
import hu.zerotohero.dotda.model.location.LocationDao;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.item.Item;
import hu.zerotohero.dotda.model.location.Location;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class DefaultActionService implements ActionService {

    @Autowired
    private DefaultCharacterService defaultCharacterService;

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private LocationDao locationDao;

    public int attack(Character attacker, Character defender, int currentHealth, String modifier) {
        return 0;
    }

    @Transactional
    public void trade(Character seller, Character buyer, Item item) {

    }

    public void search(Character character) {

    }

    public void travel(Character traveler, Location goal) {

    }
}
