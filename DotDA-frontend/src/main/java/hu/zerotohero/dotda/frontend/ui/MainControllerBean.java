package hu.zerotohero.dotda.frontend.ui;

import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
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
public class MainControllerBean {

    private Player activePlayer = null;
    private PlayerCharacter activeCharacter = null;
    private MenuLayout menuLayout;
    private HorizontalSplitPanel mainLayoutContainer;

}
