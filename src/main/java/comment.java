import javax.persistence.*;

@Entity
@Table(schema = "projecttracker", name = "comment")
public class comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer commentID;

    String text;
    @ManyToOne
    @JoinColumn(name = "itemID")
    Item itemID;
}