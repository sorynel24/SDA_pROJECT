import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentService {

    private static CommentService Instance;

    public CommentService(){
    }

    public static CommentService getInstance(){
        if (Instance == null){
            Instance = new CommentService();
        }
        return null;
    }

    public comment getComment(Integer ID){
        try{
            Session TypeSession = H_util.getSessionFactory().openSession();
            return TypeSession.find(comment.class, ID);
        }catch (Exception EX){
            EX.printStackTrace();
            return null;
        }
    }

    public void setCommnent(comment C){
        Transaction CommentTransaction = null;
        try{
            Session session = H_util.getSessionFactory().getCurrentSession();
            CommentTransaction = session.beginTransaction();

            CommentTransaction.commit();
            session.close();
        }catch (Exception E) {
            if (CommentTransaction != null) {
                CommentTransaction.rollback();
            }
            E.printStackTrace();
        }
    }
}
