import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemService {
    private static ItemService instance;

    public ItemService(){
    }

    public ItemService getInstance(){
        if(instance == null){
            instance = new ItemService();
        }
        return instance;
    }

    public Item getItem(Integer ID){
        try{
            Session ItemSession = H_util.getSessionFactory().openSession();
            return ItemSession.find(Item.class, ID);
        }catch (Exception EX){
            EX.printStackTrace();
            return null;
        }
    }

    public void setItem(Item i){
        Transaction ItemTransaction = null;
        try{
            Session session = H_util.getSessionFactory().getCurrentSession();
            ItemTransaction = session.beginTransaction();

            ItemTransaction.commit();
            session.close();
        }catch (Exception E) {
            if (ItemTransaction != null) {
                ItemTransaction.rollback();
            }
            E.printStackTrace();
        }
    }
}
