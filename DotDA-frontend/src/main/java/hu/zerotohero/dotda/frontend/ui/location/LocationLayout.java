package hu.zerotohero.dotda.frontend.ui.location;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;
import hu.zerotohero.dotda.backend.service.character.HardCharacterService;
import hu.zerotohero.dotda.frontend.ui.Content;
import hu.zerotohero.dotda.frontend.ui.MainControllerBean;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import hu.zerotohero.dotda.model.context.AppCtx;
import hu.zerotohero.dotda.model.location.LocationType;

import java.io.File;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public class LocationLayout extends VerticalLayout implements Content {

    private Button locationChangeButton;
    private Embedded picture;
    private Label locationName;

    public LocationLayout() {
        locationChangeButton = new Button();
        picture = new Embedded();
        locationName = new Label();
        locationName.setSizeUndefined();

        locationChangeButton.addClickListener(event -> {
            changeCharacterLocation();
            changeContent();
        });

        this.addComponents(locationName, picture, locationChangeButton);
        this.setComponentAlignment(picture, Alignment.MIDDLE_CENTER);
        this.setComponentAlignment(locationChangeButton, Alignment.BOTTOM_CENTER);
        this.setComponentAlignment(locationName, Alignment.TOP_CENTER);
        changeContent();
    }

    private void changeContent() {

        PlayerCharacter activeCharacter = AppCtx.bean(MainControllerBean.class).getActiveCharacter();
        LocationType locationType = activeCharacter.getLocation().getLocationType();
        changeButtonCaption(locationType);
        changePicture(locationType);
        locationName.setValue(activeCharacter.getLocation().getName());

    }

    private void changeButtonCaption(LocationType characterLocationType) {
        if (characterLocationType.getName().equals("city")) {
            locationChangeButton.setCaption("Go to the swamp");
        } else {
            locationChangeButton.setCaption("Go to the city");
        }
    }

    private void changePicture(LocationType characterLocationType) {
        String basePath = VaadinService
                .getCurrent()
                .getBaseDirectory()
                .getAbsolutePath();
        if (characterLocationType.getName().equals("city")) {
            picture.setSource(new FileResource(new File(basePath + "/WEB-INF/images/city.jpg")));
        } else {
            picture.setSource(new FileResource(new File(basePath + "/WEB-INF/images/swamp.jpg")));
        }
    }

    private void changeCharacterLocation() {
        PlayerCharacter playerCharacter = AppCtx.bean(MainControllerBean.class).getActiveCharacter();
        AppCtx.bean(HardCharacterService.class).changeCharacterLocation(playerCharacter);
    }

}
