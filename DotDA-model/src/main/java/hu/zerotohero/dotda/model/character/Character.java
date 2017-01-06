package hu.zerotohero.dotda.model.character;

import hu.zerotohero.dotda.model.base.BaseEntity;
import hu.zerotohero.dotda.model.character.characterclass.CharacterClass;
import hu.zerotohero.dotda.model.item.Item;
import hu.zerotohero.dotda.model.location.Location;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Entity
@Table(name = "character")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"characterClass", "race", "location", "inventory"})
@DiscriminatorColumn(name = "discriminator")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Character extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "currency")
    private Integer currency;

    @ManyToOne
    @JoinColumn(name = "character_class_id", referencedColumnName = "id")
    private CharacterClass characterClass;

    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToMany
    @JoinTable(name = "character_inventory",
            joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"))
    private List<Item> inventory;

    public abstract void accept(CharacterVisitor characterVisitor);
}
