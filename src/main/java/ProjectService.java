import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProjectService {
    private static ProjectService instance;

    ProjectService(){
    }

    public static ProjectService getInstance(){
        if(instance == null){
            instance = new ProjectService();
        }
        return instance;
    }

    public Project getNewProject(Integer ID){
        try{
            Session session = H_util.getSessionFactory().openSession();
            return session.find(Project.class, ID);
        }catch(Exception EX){
            EX.printStackTrace();
            return null;
        }
    }

    public void setProject(Project currentProject){
        Transaction projectTransaction = null;
        try{
            Session ProjectSession = H_util.getSessionFactory().getCurrentSession();
            projectTransaction = ProjectSession.beginTransaction();

            projectTransaction.commit();
            ProjectSession.close();
        }catch (Exception Ex){
            if(projectTransaction != null){
                projectTransaction.rollback();
            }
            Ex.printStackTrace();
        }
    }
}
