package hu.zerotohero.dotda.backend.service.player;


import hu.zerotohero.dotda.backend.service.player.exception.AuthenticationException;
import hu.zerotohero.dotda.backend.service.player.exception.RegistrationException;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.player.Player;
import hu.zerotohero.dotda.model.player.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class DefaultPlayerManagerService implements PlayerManagerService {

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private BaseDao baseDao;

    @Override
    @Transactional
    public Player register(String username, String password)
            throws RegistrationException {
        if (playerDao.findPlayerByUsername(username) != null) {
            throw new RegistrationException("Player already exists! (try to log in, or choose another username)");
        } else {
            Player newPlayer = Player.builder()
                    .username(username)
                    .passwordHash(password)
                    .build();

            baseDao.save(newPlayer);
            return newPlayer;
        }
    }

    @Override
    @Transactional
    public Player login(String username, String password)
            throws AuthenticationException {
        Player player = playerDao.findPlayerByUsername(username);

        if (player == null) {
            throw new AuthenticationException("Player with username: "
                    + username
                    + " does not exists! (look for typos, or register a new player)");
        } else if (!player.getPasswordHash().equals(password)) {
            throw new AuthenticationException("Invalid password, please try again!");
        } else {
            return player;
        }
    }
}
