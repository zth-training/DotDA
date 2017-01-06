package hu.zerotohero.dotda.frontend.ui.character;

import com.vaadin.ui.*;
import hu.zerotohero.dotda.frontend.ui.Content;
import hu.zerotohero.dotda.frontend.ui.MainControllerBean;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.context.AppCtx;

import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class CharacterLayout extends VerticalLayout implements Content {

    private Table characterTable;
    private Button refreshButton;
    private Label siteName = new Label("Characters");
    private Label activeCharacterName;

    public CharacterLayout() {
        characterTable = new Table();
        refreshButton = new Button("Refresh");
        activeCharacterName = new Label(AppCtx.bean(MainControllerBean.class).getActiveCharacter().getName());

        siteName.setSizeUndefined();
        activeCharacterName.setSizeUndefined();

        refreshButton.addClickListener(event -> refresh());

        initTable();

        this.addComponents(siteName, characterTable, activeCharacterName, refreshButton);
        this.setComponentAlignment(siteName, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(characterTable, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(activeCharacterName, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(refreshButton, Alignment.MIDDLE_CENTER);
    }

    private void initTable() {
        characterTable.addContainerProperty("Name", String.class, null);
        characterTable.addContainerProperty("Character class", String.class, null);
        characterTable.addContainerProperty("Strength", Integer.class, null);
        characterTable.addContainerProperty("Agility", Integer.class, null);
        characterTable.addContainerProperty("Intelligence", Integer.class, null);
        characterTable.addContainerProperty("Wisdom", Integer.class, null);

        characterTable.setSelectable(true);

        List<PlayerCharacter> playerCharacters = AppCtx.bean(MainControllerBean.class).getActivePlayer().getCharacters();
        for (int i = 0; i < playerCharacters.size(); i++) {
            characterTable.addItem(AppCtx.bean(CharacterControllerBean.class).mapCharacterToTables(playerCharacters.get(i)), i);
        }

        characterTable.addItemClickListener(event -> {
            PlayerCharacter activeCharacter = AppCtx.bean(CharacterControllerBean.class).getSelectedCharacter((String) event.getItem().getItemProperty("Name").getValue());
            AppCtx.bean(MainControllerBean.class)
                    .setActiveCharacter(activeCharacter);
            activeCharacterName.setValue(activeCharacter.getName());
        });

    }

    private void refresh() {
        characterTable = new Table();
        initTable();
    }

}
