package hu.zerotohero.dotda.model.player;

import com.avaje.ebean.Ebean;
import hu.zerotohero.dotda.model.base.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class PlayerDao {

    public Player findPlayerByUsername(String username) {
        return Ebean.find(Player.class)
                .where()
                .eq("username", username)
                .findUnique();
    }
}
