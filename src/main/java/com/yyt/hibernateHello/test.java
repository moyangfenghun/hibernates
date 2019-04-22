package com.yyt.hibernateHello;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yyt.hibernateHello.bean.Customer;
import com.yyt.hibernateHello.bean.Order;
import com.yyt.hibernateHello.testbean.user;

public class test {
	
	// 定义一个静态的日志器变量，引用名为MyApp的实例
    private static final Logger logger = LoggerFactory.getLogger(test.class);
    private static final org.apache.logging.log4j.Logger LOGGER2=LogManager.getLogger(test.class);
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction beginTransaction = session.beginTransaction();

//		Hqlselect(session);
//		user user = session.get(user.class, 1000);
//		
//		System.out.println(user);
		
		beginTransaction.commit();
		session.close();
		factory.close();
	}
	
	@Test
	public void mytest() {
		Configuration configuration = new Configuration().configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();

		Transaction beginTransaction = session.beginTransaction();

//		System.out.println(session.get(user.class, 1001));
		
		Hqlselect(session);
		
		
		beginTransaction.commit();
		session.close();
		
		
	
		factory.close();
	}

	//简单的查询
	public void Hqlselect(Session session) {
//		使用  '?0' 或者  '：命名参数' 代替;版本4.2以后使用 '?+数字'，以前使用'?'
		String Hql = "from user where id=?0";

		//session.createSQLQuery(queryString);本地sql查询
		Query createQuery = session.createQuery(Hql);
		
		createQuery.setCacheable(true);//手动开启二级缓存
		
		createQuery.setParameter(0, 1000);

		List<user> resultList = createQuery.getResultList();

		for (user object : resultList) {
			System.out.println(object);
		}
		
		createQuery.setParameter(0, 1000);

		List<user> resultList2 = createQuery.getResultList();

		for (user object : resultList2) {
			System.out.println(object);
		}
//		--------------
//		Query createQuery2 = session.getNamedQuery("myselectbyid");
//		
//		createQuery2.setParameter(0, 1000);
//
//		List<user> resultList2 = createQuery2.getResultList();
//
//		for (user object2 : resultList2) {
//			System.out.println(object2);
//		}
		
	}
	//分页
	public void pageselect(Session session) {
//		String Hql="select new user(e.id,e.name) from user e";
		String Hql2="select e.id,e.name from user e";
		int pageindex=2;//第几页
		int pageNumber=3;
		
		Query query=session.createQuery(Hql2);
		
		query.setFirstResult((pageindex-1)*pageNumber).setMaxResults(pageNumber);
//		
//		List<user> resultList = query.getResultList();
//		for (user user : resultList) {
//			logger.info(user.id+"--"+user.name);
//		}
//		
		List<Object[]> objecta = query.getResultList();
		for (Object[] objects : objecta) {
			logger.info(Arrays.asList(objects).toString());
		}
	}
	
	
	public void userupdateproperty(Session session) {
		String Hql="update  user f set f.name=?1 where f.id=?2";
		
		Query query=session.createQuery(Hql);
		query.setParameter(1, "我自更新");
		query.setParameter(2, 1000);
		
		int executeUpdate = query.executeUpdate();
		System.out.println("更新记录数："+executeUpdate);
	}
	
	
	public void leftjoinFETCH(Session sess) {
		//迫切左外连接，一开始会初始化关联的表。后续不在发送sql
		String Hql1="select distinct c from Customer c left join fetch c.order";
		//使用时才初始化关联的对象，每次使用时会再次发送sql。会按照配置文件来检索
		String Hql="select distinct c from Customer c left join c.order";
		Query createQuery = sess.createQuery(Hql);
		List<Customer> resultList = createQuery.getResultList();
		for (Customer customer : resultList) {
			logger.info(customer.getName());
			logger.info(customer.getOrder().size()+"");
		}
	
	}
	

}
