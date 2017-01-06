package hu.zerotohero.dotda.model.attribute;

import hu.zerotohero.dotda.model.item.Item;
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
@DiscriminatorValue("I")
@EqualsAndHashCode(callSuper = true, exclude = "item")
public class ItemAttribute extends Attribute {

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
}
