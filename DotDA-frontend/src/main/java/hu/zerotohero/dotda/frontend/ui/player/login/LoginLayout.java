package hu.zerotohero.dotda.frontend.ui.player.login;

import com.vaadin.ui.*;
import hu.zerotohero.dotda.frontend.ui.Content;
import hu.zerotohero.dotda.frontend.ui.MainControllerBean;
import hu.zerotohero.dotda.frontend.ui.character.CharacterLayout;
import hu.zerotohero.dotda.model.context.AppCtx;
import hu.zerotohero.dotda.model.player.Player;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class LoginLayout extends VerticalLayout implements Content {

    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;
    private Button registrationButton;

    public LoginLayout() {

        usernameField = new TextField("Username:");
        passwordField = new PasswordField("Password:");
        loginButton = new Button("Login");
        registrationButton = new Button("Registration");

        // Java 8 lambda expression
        loginButton.addClickListener(event -> login());

        // Traditional method (anonymus innerclass definition)
        registrationButton.addClickListener(new Button.ClickListener() {

            @Override
            public void buttonClick(Button.ClickEvent event) {
                register();
            }

        });

        HorizontalLayout textLayout = new HorizontalLayout(usernameField, passwordField);
        HorizontalLayout buttonLayout = new HorizontalLayout(loginButton, registrationButton);
        this.addComponents(textLayout, buttonLayout);
        this.setComponentAlignment(textLayout, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);

        textLayout.setMargin(true);
        buttonLayout.setMargin(true);

    }

    private void login() {
        String username = usernameField.getValue();
        String password = passwordField.getValue();

        if (!(isStringNullOrEmpty(username) || isStringNullOrEmpty(password))) {
            Player player = AppCtx.bean(LoginControllerBean.class).login(username, password);
            changeContent(player);
        } else {
            Notification.show("Login failed!", "Username and password are both required!", Notification.Type.WARNING_MESSAGE);
        }
    }

    private void register() {
        String username = usernameField.getValue();
        String password = passwordField.getValue();

        if (!(isStringNullOrEmpty(username) || isStringNullOrEmpty(password))) {
            Player player = AppCtx.bean(LoginControllerBean.class).register(username, password);
            changeContent(player);
        } else {
            Notification.show("Registration failed!", "Username and password are both required!", Notification.Type.WARNING_MESSAGE);
        }

    }

    private void changeContent(Player player) {
        if (player != null) {
            MainControllerBean mainControllerBean = AppCtx.bean(MainControllerBean.class);
            mainControllerBean.setActivePlayer(player);
            mainControllerBean.setActiveCharacter(player.getCharacters().get(0));
            mainControllerBean.getMenuLayout().setButtonsEnabled(true);
            mainControllerBean.getMainLayoutContainer()
                    .setSecondComponent(new CharacterLayout());
            usernameField.setValue("");
            passwordField.setValue("");
        }
    }

    private boolean isStringNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
