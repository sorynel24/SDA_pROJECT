import javax.persistence.*;

@Entity
@Table(schema = "projecttracker", name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer projectID;

    String project_name;

    String project_short_name;

    StringBuilder Description;

    @OneToOne(mappedBy = "project_status")
    Status statusID;
}
