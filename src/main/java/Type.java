import javax.persistence.*;

@Entity
@Table(schema = "projecttracker", name = "item")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer typeID;

    String name;

    @OneToOne(mappedBy = "Item_Type")
    Item type_Of_Item;
}
