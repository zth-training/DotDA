package hu.zerotohero.dotda.backend.service.player;

import hu.zerotohero.dotda.backend.service.player.exception.AuthenticationException;
import hu.zerotohero.dotda.backend.service.player.exception.RegistrationException;
import hu.zerotohero.dotda.model.player.Player;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
public class HashPlayerManagerService implements PlayerManagerService {

    @Override
    public Player register(String username, String password) throws RegistrationException {
        return null;
    }

    @Override
    public Player login(String username, String password) throws AuthenticationException {
        return null;
    }
}
