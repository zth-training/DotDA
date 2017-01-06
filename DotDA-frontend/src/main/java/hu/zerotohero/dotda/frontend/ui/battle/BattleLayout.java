package hu.zerotohero.dotda.frontend.ui.battle;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import hu.zerotohero.dotda.backend.service.action.ActionService;
import hu.zerotohero.dotda.backend.service.battle.BattleService;
import hu.zerotohero.dotda.backend.service.character.HardCharacterService;
import hu.zerotohero.dotda.backend.service.character.calculator.CharacterAttributeCalculator;
import hu.zerotohero.dotda.frontend.ui.Content;
import hu.zerotohero.dotda.frontend.ui.MainControllerBean;
import hu.zerotohero.dotda.frontend.ui.character.CharacterLayout;
import hu.zerotohero.dotda.model.attribute.AttributeType;
import hu.zerotohero.dotda.model.base.BaseDao;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.character.CharacterDao;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.context.AppCtx;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class BattleLayout extends HorizontalSplitPanel implements Content {

    private FighterLayout attackerLayout;
    private FighterLayout defenderLayout;
    private BattleService battleService;

    public BattleLayout() {
        attackerLayout = new FighterLayout(AppCtx.bean(MainControllerBean.class)
                .getActiveCharacter());

        defenderLayout = new FighterLayout(AppCtx.bean(BattleControllerBean.class)
                .getEnemy());

        this.setFirstComponent(attackerLayout);
        this.setSecondComponent(defenderLayout);

        battleService =new BattleService(
                attackerLayout.getFighter(),
                defenderLayout.getFighter(),
                attackerLayout.getFighter().getLocation(),
                AppCtx.bean(HardCharacterService.class),
                AppCtx.bean(ActionService.class),
                AppCtx.bean(CharacterDao.class),
                AppCtx.bean(BaseDao.class)
        );

        AppCtx.bean(BattleControllerBean.class).newBattleStart(battleService);
        attackerLayout.getPhysicalAttack().addClickListener(event -> {
            if (battleService.getWinner() == null){
                battleService.attack(attackerLayout.getFighter(), "physical");
            } if (battleService.getWinner() == attackerLayout.getFighter()) {
                Notification.show("You won!", Notification.Type.HUMANIZED_MESSAGE);
                AppCtx.bean(MainControllerBean.class).getMainLayoutContainer().setSecondComponent(new CharacterLayout());
            } else {
                Notification.show("You lost!", Notification.Type.HUMANIZED_MESSAGE);
                AppCtx.bean(MainControllerBean.class).getMainLayoutContainer().setSecondComponent(new CharacterLayout());
            }
        });

        attackerLayout.getMagicAttack().addClickListener(event -> {
            if (battleService.getWinner() == null){
                battleService.attack(attackerLayout.getFighter(), "magical");
            } if (battleService.getWinner() == attackerLayout.getFighter()) {
                Notification.show("You won!", Notification.Type.HUMANIZED_MESSAGE);
                AppCtx.bean(MainControllerBean.class).getMainLayoutContainer().setSecondComponent(new CharacterLayout());
            } else {
                Notification.show("You lost!", Notification.Type.HUMANIZED_MESSAGE);
                AppCtx.bean(MainControllerBean.class).getMainLayoutContainer().setSecondComponent(new CharacterLayout());
            }
        });

    }



    @Getter
    @Setter
    private class FighterLayout extends VerticalLayout {

        private Character fighter;
        private Embedded avatar;
        private Label name;
        private Label health;
        private Button physicalAttack;
        private Button magicAttack;

        public FighterLayout(Character fighter) {
            this.fighter = fighter;

            name = new Label(fighter.getName());
            health = new Label(String.valueOf(AppCtx.bean(CharacterAttributeCalculator.class).getAttributeValueByAttributeType(fighter, AttributeType.HEALTH)));
            name.setSizeUndefined();
            health.setSizeUndefined();
            avatar = new Embedded();
            avatar.setHeight(70, Unit.PERCENTAGE);
            avatar.setWidth(100, Unit.PERCENTAGE);
            initAvatar(fighter);
            this.addComponents(avatar, name, health);

            if (fighter instanceof PlayerCharacter) {

                physicalAttack = new Button("Attack");
                magicAttack = new Button("Cast magic");
                HorizontalLayout buttonLayout = new HorizontalLayout(physicalAttack, magicAttack);
                buttonLayout.setComponentAlignment(physicalAttack, Alignment.MIDDLE_CENTER);
                buttonLayout.setComponentAlignment(magicAttack, Alignment.MIDDLE_CENTER);
                this.addComponents(buttonLayout);
                this.setComponentAlignment(buttonLayout, Alignment.MIDDLE_CENTER);
            }

            this.setComponentAlignment(avatar, Alignment.MIDDLE_CENTER);
            this.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
            this.setComponentAlignment(health, Alignment.MIDDLE_CENTER);
        }

        private void initAvatar(Character fighter) {
            String pathToResource = VaadinService
                    .getCurrent()
                    .getBaseDirectory()
                    .getAbsolutePath()
                    + "/WEB-INF/images/";

            switch (fighter.getRace().getName()) {
                case "Ironfoot Dwarf": {
                    pathToResource = pathToResource + "axeman.jpg";
                    break;
                }
                case "Runespeaker Dwarf": {
                    pathToResource = pathToResource + "runemaster.jpg";
                    break;
                }
                case "Deadeye troll": {
                    pathToResource = pathToResource + "troll.jpg";
                    break;
                }
                case "Swampgoblin": {
                    pathToResource = pathToResource + "goblin.jpg";
                    break;
                }
            }

            avatar.setSource(new FileResource(new File(pathToResource)));

        }

    }
}
