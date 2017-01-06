package hu.zerotohero.dotda.backend.service.action;

import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.item.Item;
import hu.zerotohero.dotda.model.location.Location;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public interface ActionService {

    int attack(Character attacker, Character defender, int currentHealth, String modifier);

    void trade(Character seller, Character buyer, Item item);

    void search(Character character);

    void travel(Character traveler, Location goal);

}
