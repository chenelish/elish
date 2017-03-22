package com.elish.hibernate;






import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import org.jboss.logging.Logger;




public class test {
	
  private	static Transaction tx=null;
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		 Logger log=LoggerFactory.logger(test.class);
    Configuration cfg=new Configuration();
    cfg.configure("hibernate.cfg.xml");
    StandardServiceRegistry registry = null;
    registry = new StandardServiceRegistryBuilder().configure().build();
    SessionFactory sfc=new MetadataSources(registry).buildMetadata()
			.buildSessionFactory();
    Session session=null;
    session=sfc.openSession();
    tx=session.beginTransaction();
    Query query=session.createQuery("from hibernate where name=?");
    query.setString(0, "chen");
  /*  String id="1";
    user us=(user)session.get(user.class,id);*/  //标识符选择
    user us=(user)query.uniqueResult();//hql选择
    System.out.println(us);
    log.info(us.getName());
    tx.commit();
    session.close();
    
    
	}

}
