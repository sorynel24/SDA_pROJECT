import org.hibernate.Session;
import org.hibernate.Transaction;

public class statusService {

    private static statusService Instance;

    statusService(){
    }

    public static statusService getInstance(){
        if(Instance == null){
            Instance = new statusService();
        }
        return Instance;
    }

    public Status getStatusService(Integer ID){
        try{
            Session statusSession = H_util.getSessionFactory().openSession();
            return statusSession.find(Status.class, ID);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void createStatus(Status theStatus){
        Transaction transaction = null;
            try{
                Session session = H_util.getSessionFactory().getCurrentSession();
                transaction = session.beginTransaction();

                session.save(theStatus);

            transaction.commit();
            session.close();
        }catch(Exception E){
            if(transaction != null){
                transaction.rollback();
            }
            E.printStackTrace();
        }
    }
}
