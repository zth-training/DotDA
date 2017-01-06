package hu.zerotohero.dotda.model.player;

import hu.zerotohero.dotda.model.base.BaseEntity;
import hu.zerotohero.dotda.model.character.Character;
import hu.zerotohero.dotda.model.character.PlayerCharacter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Entity
@Table(name = "player")
@Data
@Builder
@EqualsAndHashCode(callSuper = true, exclude = {"characters"})
public class Player extends BaseEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @OneToMany(mappedBy = "player")
    private List<PlayerCharacter> characters;

    @Override
    public String toString() {
        return username;
    }
}
