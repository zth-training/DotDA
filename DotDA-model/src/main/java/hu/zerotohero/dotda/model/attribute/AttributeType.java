package hu.zerotohero.dotda.model.attribute;

import com.avaje.ebean.annotation.EnumValue;
import lombok.AllArgsConstructor;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@AllArgsConstructor
public enum AttributeType {

    @EnumValue("Health")
    HEALTH("Health"),

    @EnumValue("Mana")
    MANA("Mana"),

    @EnumValue("Stamina")
    STAMINA("Stamina"),

    @EnumValue("Strength")
    STRENGTH("Strength"),

    @EnumValue("Agility")
    AGILITY("Agility"),

    @EnumValue("Intelligence")
    INTELLIGENCE("Intelligence"),

    @EnumValue("Wisdom")
    WISDOM("Wisdom"),

    @EnumValue("CriticalRating")
    CRITIAL_RATING("Critical Rating"),

    @EnumValue("Speed")
    SPEED("Speed");

    private String presentationName;

    @Override
    public String toString() {
        return presentationName;
    }

}
