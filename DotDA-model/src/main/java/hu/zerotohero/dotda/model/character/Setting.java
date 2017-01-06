package hu.zerotohero.dotda.model.character;

import com.avaje.ebean.annotation.EnumValue;
import lombok.AllArgsConstructor;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@AllArgsConstructor
public enum Setting {

    @EnumValue("Normal")
    NORMAL("Normal"),

    @EnumValue("Hard")
    HARD("Hard");

    private String presentationName;

    @Override
    public String toString() {
        return presentationName;
    }

}
