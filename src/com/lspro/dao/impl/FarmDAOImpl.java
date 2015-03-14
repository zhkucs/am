package com.lspro.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.lspro.dao.inter.IFarmDAO;
import com.lspro.pojo.FarmMes;

/**
 * Desperation:
 * 此操作类实现了IFarmDAO接口，用于增删改查方法的实现<br>
 * @author 阿呆
 * @see IFarmDAO
 * @see FarmMes
 * @version 2.0(将增删改查的close方法去掉，于调用类中使用即可，同时Transaction获取事物于每个功能方法中，而不是在构造方法,以及去掉每个功能方法中的try...catch)
 */

public class FarmDAOImpl implements IFarmDAO{
	/**
	 * 用于数据的持久化的操作以及事物的处理
	 */
	private SessionFactory sf = null;
	private Session sess = null;
	private Transaction tx = null;
	private static String sql = "from FarmMes as farm where farm.farmId like :name or farm.farmName like :name or farm.location like :name or " +
			"farm.phoneNum like :name or farm.ImmunePro like :name or farm.certificate like :name";
	
	/**
	 *  无参构造法，用于实例化SessionFactory,Session,Transaction对象,以便增删改查功能的实现.
	 */
	public FarmDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(serviceRegistry);
		sess = sf.openSession();
	}
	

	public boolean doCreate(FarmMes vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.save(vo); //把数据保存到数据库中。
		tx.commit();
		return true;
	}


	public boolean doUpdate(FarmMes vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);  //修改数据
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		FarmMes mes = (FarmMes) sess.load(FarmMes.class, id);  //删除数据
		sess.delete(mes);
		return true;
	}

	public FarmMes findById(String id) throws Exception {
		// TODO Auto-generated method stub
		FarmMes mes = (FarmMes) sess.load(FarmMes.class, id);  //查找数据
		return mes;
		
	}

	public List<FarmMes> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<FarmMes> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //模糊查询
		return list;	
	}

	public List<FarmMes> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //分页查询
		query.setFirstResult((currentPage - 1 ) * lineSize);
		query.setMaxResults(lineSize);
		List<FarmMes> list = query.list();
		return list;		
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		int record = sess.createQuery(sql).setString("name", "%" + keyWord + "%").list().size();  //获取数据的数目
		return record;
		
	}
	
	/**
	 * 关闭数据连接
	 */
	public void close(){
		sess.close();
		sf.close();
	}

}
