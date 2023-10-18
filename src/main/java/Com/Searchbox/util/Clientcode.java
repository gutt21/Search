


package Com.Searchbox.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class Clientcode {
	
	public static void main(String[] args) {
		
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getsessionFactory().openSession();
			Akash a=new Akash();
			a.setName("ramesh");
			a.setLast("sab");
		    transaction = session.beginTransaction();
			session.persist(a);
			transaction.commit();
			session.close();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		   //Search condition
	     	try  (Session session = HibernateUtil.getsessionFactory().openSession()) {
				Query<Akash> q = session.createQuery("from Akash", Akash.class);
				//q.setParameter("NAME", "Khadar");
				List<Akash> A = q.getResultList();
				 for(Akash aa:A) {
					 System.out.println(aa.getName());
				 }
				
				A.forEach(b -> {
					//System.out.println("Print book name : " + b.getName());
				});
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		
	    }
	
}
