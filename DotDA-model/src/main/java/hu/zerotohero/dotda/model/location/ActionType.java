package hu.zerotohero.dotda.model.location;

import com.avaje.ebean.annotation.EnumValue;
import lombok.AllArgsConstructor;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@AllArgsConstructor
public enum ActionType {

    @EnumValue("Search")
    SEARCH("Search"),

    @EnumValue("Attack")
    ATTACK("Attack"),

    @EnumValue("Trade")
    TRADE("Trade");

    private String presentationName;

    @Override
    public String toString() {
        return presentationName;
    }

}
