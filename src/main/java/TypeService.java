import org.hibernate.Session;
import org.hibernate.Transaction;

public class TypeService {

    private static TypeService instance;

    public TypeService(){
    }

    public Type getType(Integer ID){
        try{
            Session TypeSession = H_util.getSessionFactory().openSession();
            return TypeSession.find(Type.class, ID);
        }catch (Exception EX){
            EX.printStackTrace();
            return null;
        }
    }

    public void createType(Type T){
        Transaction TypeTransaction = null;
        try{
            Session session = H_util.getSessionFactory().getCurrentSession();
            TypeTransaction = session.beginTransaction();

            TypeTransaction.commit();
            session.close();
        }catch (Exception E) {
            if (TypeTransaction != null) {
                TypeTransaction.rollback();
            }
            E.printStackTrace();
        }
    }
}
