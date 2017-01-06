package hu.zerotohero.dotda.model.attribute;

import hu.zerotohero.dotda.model.character.Race;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("R")
@EqualsAndHashCode(callSuper = true, exclude = "race")
public class RaceAttribute extends Attribute {

    @ManyToOne
    @JoinColumn(name = "race_id", referencedColumnName = "id")
    private Race race;

}
