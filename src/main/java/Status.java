import javax.persistence.*;

@Entity
@Table(schema = "projecttracker", name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer statusID;

    String statusName;

    @OneToOne
    @JoinColumn(name = "project_status")
    Project status_project;

    @OneToMany(mappedBy = "Item_Status")
    Item itemStatus;



}
