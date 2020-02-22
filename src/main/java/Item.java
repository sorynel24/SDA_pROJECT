import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "projecttracker", name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer itemID;

    String title;

    StringBuilder description;

    Integer statusID;

    Integer typeID;

    @OneToMany(mappedBy = "itemID")
    List<Item> listComments;

    @ManyToOne
    @JoinColumn(name = "Item_Status")
    Status item_Status;

    @OneToOne
    @JoinColumn(name = "Item_Type")
    Type Item_type;
}
