package hu.zerotohero.dotda.model.item;

import com.avaje.ebean.annotation.EnumValue;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
public enum Slot {

    @EnumValue("Head")
    HEAD("Head"),

    @EnumValue("Neck")
    NECK("Neck"),

    @EnumValue("Torso")
    TORSO("Torso"),

    @EnumValue("LeftArm")
    ARM_LEFT("Left arm"),

    @EnumValue("RightArm")
    ARM_RIGHT("Right arm"),

    @EnumValue("LeftHand")
    HAND_LEFT("Left hand"),

    @EnumValue("RightHand")
    HAND_RIGHT("Right hand"),

    @EnumValue("LeftLeg")
    LEG_LEFT("Left leg"),

    @EnumValue("RightLeg")
    LEG_RIGHT("Right leg"),

    @EnumValue("LeftRing")
    RING_LEFT("Left Ring"),

    @EnumValue("RightRing")
    RING_RIGHT("Right ring"),

    @EnumValue("Backpack")
    BACKPACK("Backpack");

    private String presentationName;

    Slot(String presentationName) {
        this.presentationName = presentationName;
    }

    @Override
    public String toString() {
        return presentationName;
    }

}
