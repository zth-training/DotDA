package hu.zerotohero.dotda.frontend.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import hu.zerotohero.dotda.frontend.ui.battle.BattleLayout;
import hu.zerotohero.dotda.frontend.ui.character.CharacterCreationLayout;
import hu.zerotohero.dotda.frontend.ui.character.CharacterLayout;
import hu.zerotohero.dotda.frontend.ui.location.LocationLayout;
import hu.zerotohero.dotda.frontend.ui.player.login.LoginLayout;
import hu.zerotohero.dotda.model.context.AppCtx;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class MenuLayout extends VerticalLayout {

    private Button characterButton;
    private Button characterCreationButton;
    private Button locationButton;
    private Button battleButton;
    private Button logoutButton;

    public MenuLayout() {

        this.setSizeFull();
        initButtons();
        setButtonsEnabled(false);

        this.addComponents(
                characterButton,
                characterCreationButton,
                battleButton,
                locationButton,
                logoutButton
        );

    }

    public void setButtonsEnabled(boolean enabled) {
        characterButton.setEnabled(enabled);
        characterCreationButton.setEnabled(enabled);
        battleButton.setEnabled(enabled);
        locationButton.setEnabled(enabled);
        logoutButton.setEnabled(enabled);
    }

    private void initButtons() {
        characterButton = new Button("Character");
        characterButton.setSizeFull();
        characterButton.addClickListener(
                event -> changeContent(new CharacterLayout())
        );

        characterCreationButton = new Button("Character creation");
        characterCreationButton.setSizeFull();
        characterCreationButton.addClickListener(
                event -> changeContent(new CharacterCreationLayout())
        );

        battleButton = new Button("Battle");
        battleButton.setSizeFull();
        battleButton.addClickListener(
                event -> changeContent(new BattleLayout())
        );

        locationButton = new Button("Location");
        locationButton.setSizeFull();
        locationButton.addClickListener(
                event -> changeContent(new LocationLayout())
        );

        logoutButton = new Button("Log out");
        logoutButton.setSizeFull();
        logoutButton.addClickListener(
                event -> {
                    changeContent(new LoginLayout());
                    setButtonsEnabled(false);
                }
        );
    }

    private void changeContent(Content content) {
        AppCtx.bean(MainControllerBean.class)
                .getMainLayoutContainer()
                .setSecondComponent(content);
    }

}
