package hu.zerotohero.dotda.model.item;

import org.springframework.transaction.annotation.Transactional;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.character.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class ItemDao {

    @Autowired
    private BaseDao baseDao;

    @Transactional
    public void transferItem(Character buyer, Character seller, Item item) {
        seller.getInventory().remove(item);
        buyer.getInventory().add(item);
        baseDao.update(seller);
        baseDao.update(buyer);
    }
}
