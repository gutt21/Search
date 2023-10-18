package Com.Searchbox.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	
	
	private static SessionFactory factory;
	
	
	static {
		if(factory == null) {
		try {	
			Configuration cfg=new Configuration().configure();
			cfg.addAnnotatedClass(Akash.class);
			StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
			factory=cfg.buildSessionFactory(registry);
		}catch (Exception e) {
			e.printStackTrace();		}
	}
	
	}
	
	
	public static SessionFactory getsessionFactory(){
		
		return factory;
	}
	
}
