package com.yyt.hibernateHello;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Test;

import com.yyt.hibernateHello.testbean.user;

/**
 * Hello world!
 *
 */
public class App 
{
	
	/**
	 * hibernate一级缓存特点：查询、新增、修改都会生成缓存,每个缓存对象只能有唯一的OID
	 * 临时对象：不存在于缓存和数据库中的记录
	 * 持久化对象：存在于缓存和数据库中
	 * 删除对象：以前存在过缓存和数据中
	 * 游离对象:没有缓存但数据库中存在记录
	 * 使用get和load的区别
	 * get:会立即查询该对象
	 *     如果查询的结果不存在返回null
	 * load:若不使用该对象,则不会立即查询，然后返回一个代理对象(延迟加载);
	 *     如果查询的结果不存在报异常
	 * ------------------
	 * update:更新游离对象时需要显式调用此方法,更新持久化对象时不会发送sql
	 * ------------------
	 * evict:从session缓存中把对象移除
	 * ------------------
	 * 如果数据库中有触发器,
	 * @param args
	 */
    public static void main( String[] args )
    {
    	//1常见Configuration
    	Configuration configuration = new Configuration().configure();
    	//2创建SessionFactory
    	SessionFactory factory = configuration.buildSessionFactory();
    	//3创建一个Session
    	Session session = factory.openSession();
    	//4开启事务
    	Transaction beginTransaction = session.beginTransaction();
    	//5执行操作
    	//session.save(new user(1,"林未名",18,"男"));
    	//6提交事务
    	//beginTransaction.commit();
    	//7关闭Session,Sessionfactory
    	//--------------------------
    	//session.persist();如果对象传入id将抛出异常
    	user user=session.get(user.class, 1013);
    	System.out.println(user);
    	user.setSex("女");
    	System.out.println("----------");
    	
    	beginTransaction.commit();
    	System.out.println(session.get(user.class, 1013));
    	/*如果数据库有触发器，需要这两句来同步数据
    	session.flush();//Session按照缓存中对象属性变化来同步更新数据库。
    	session.refresh(user);//更新缓存
    	*/
    	session.close();
    	factory.close();
    }
    
    @Test
    public void testjdbcconnection() {

    	Configuration configuration = new Configuration().configure();
    	SessionFactory factory = configuration.buildSessionFactory();

    	Session session = factory.openSession();
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
				//可以以这种方式调用jdbc原生的存储过程..
				
			}
		});
	}
    
   
}
