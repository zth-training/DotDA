package hu.zerotohero.dotda.model.character;

import com.avaje.ebean.Ebean;
import org.springframework.transaction.annotation.Transactional;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.location.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class CharacterDao {

    @Autowired
    private BaseDao baseDao;

    public Character findCharacter(String name) {
        return Ebean.find(Character.class)
                .where()
                .eq("name", name)
                .findUnique();
    }

    @Transactional
    public void saveCharacter(Character character) {
        baseDao.save(character);
    }

    @Transactional
    public void changeCharacterCurrency(Character character, int value) {
        character.setCurrency(character.getCurrency() + value);
        baseDao.update(character);
    }

    @Transactional
    public void changeCharacterLocation(Character character, Location location) {
        character.setLocation(location);
        baseDao.update(character);
    }

}
