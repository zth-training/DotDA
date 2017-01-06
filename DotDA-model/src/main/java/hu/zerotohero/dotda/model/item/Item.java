package hu.zerotohero.dotda.model.item;

import hu.zerotohero.dotda.model.attribute.ItemAttribute;
import hu.zerotohero.dotda.model.base.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Balázs Hodossy <bhodossy@gmail.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true, exclude = "attributes")
@Entity
@Table(name = "item")
public class Item extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "slot")
    private Slot slot;

    @Column(name = "value")
    private Integer value;

    @Column(name = "equipped")
    private Boolean equipped;

    @OneToMany(mappedBy = "item")
    private List<ItemAttribute> attributes;
}
