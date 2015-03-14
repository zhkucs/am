package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IProductRecordDAO接口，用于生产记录数据表增删改查方法的实现<br>
 * @author 谢福成
 * @see IProductRecordDAO
 * @see ProductionRecords
 * @version 1.0
 */

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.lspro.dao.inter.IProductRecordDAO;
import com.lspro.pojo.ProductionRecords;


public class ProductRecordDAOImpl implements IProductRecordDAO {

	private SessionFactory sf = null;
	private Session sess = null;
	private Transaction tx = null;
	private static String sql = "from ProductionRecords as pro where pro.roomNum like :name or pro.recordDate like :name or pro.birthNum like :name or " +
			"pro.putNum like :name or pro.inNum like :name or pro.deadNum like :name or pro.remainNum like :name or pro.note like :name";
	
	public ProductRecordDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf =  conf.buildSessionFactory(service);
		sess = sf.openSession();
	}
	
	public boolean doCreate(ProductionRecords vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			tx = sess.beginTransaction();
			sess.persist(vo); //把数据保存到数据库中。
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public boolean doUpdate(ProductionRecords vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			tx = sess.beginTransaction();
			sess.merge(vo);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			tx = sess.beginTransaction();
			sess.delete(sess.load(ProductionRecords.class,id));
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	
	}

	public ProductionRecords findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {

			ProductionRecords pr = (ProductionRecords) sess.load(ProductionRecords.class,id);
			return pr;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public List<ProductionRecords> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {

			List<ProductionRecords> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //模糊查询
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public List<ProductionRecords> findAll(String keyWord, int currentPage,int lineSize) throws Exception {
		// TODO Auto-generated method stub
		try {

			Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //分页查询
			query.setFirstResult((currentPage - 1 ) * lineSize);
			query.setMaxResults(lineSize);
			List<ProductionRecords> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {
			int record = sess.createQuery(sql).setString("name", "%" + keyWord + "%").list().size();  //获取数据的数目
			return record;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public void close(){
		sess.close();
		sf.close();
	}

}
