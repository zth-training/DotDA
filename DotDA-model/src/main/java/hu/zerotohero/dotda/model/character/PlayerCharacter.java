package hu.zerotohero.dotda.model.character;

import hu.zerotohero.dotda.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("P")
@EqualsAndHashCode(callSuper = true)
public class PlayerCharacter extends Character {

    @Column(name = "setting")
    private Setting setting;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    public void accept(CharacterVisitor characterVisitor) {
        characterVisitor.visit(this);
    }
}
