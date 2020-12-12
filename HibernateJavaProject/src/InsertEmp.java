import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Configuration cfg=new Configuration();
		cfg.configure("Hibernate.cfg.xml");
		
		SessionFactory sf= cfg.buildSessionFactory();
		Session s=sf.openSession();
		org.hibernate.Transaction tx=s.beginTransaction();
		
		Employee1 e=new Employee1();
		
		e.setId(2);
		e.setName("Piyush");
		e.setMobile(2345234);
		e.setEmail("piyush@gmail.com");
		
		s.save(e);
		s.flush();
		tx.commit();
		s.close();
	}

}
