package hu.zerotohero.dotda.frontend.ui.player.login;

import com.vaadin.ui.Notification;
import hu.zerotohero.dotda.backend.service.player.DefaultPlayerManagerService;
import hu.zerotohero.dotda.backend.service.player.exception.AuthenticationException;
import hu.zerotohero.dotda.backend.service.player.exception.RegistrationException;
import hu.zerotohero.dotda.model.context.AppCtx;
import hu.zerotohero.dotda.model.player.Player;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Service
@Getter
@Setter
public class LoginControllerBean {

    public Player login(String username, String password) {

        Player activePlayer = null;

        try {
            activePlayer = AppCtx.bean(DefaultPlayerManagerService.class).login(username, password);
        } catch (AuthenticationException ae) {
            Notification.show("Authentication failed", ae.getMessage(), Notification.Type.WARNING_MESSAGE);
        } catch (Exception e) {
            Notification.show("Unknown error occurred", "Please contact the developer", Notification.Type.WARNING_MESSAGE);
        }
        return activePlayer;
    }

    public Player register(String username, String password) {

        Player activePlayer = null;

        try {
            activePlayer = AppCtx.bean(DefaultPlayerManagerService.class).register(username, password);
        } catch (RegistrationException re) {
            Notification.show("Registration failed", re.getMessage(), Notification.Type.WARNING_MESSAGE);
        } catch (Exception e) {
            Notification.show("Unknown error occurred", "Please contact the developer", Notification.Type.WARNING_MESSAGE);
        }
        return activePlayer;
    }

}
