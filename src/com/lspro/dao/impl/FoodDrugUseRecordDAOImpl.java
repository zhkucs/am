package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IFoodDrugUseRecordDAO接口，用于生产记录数据表增删改查方法的实现<br>
 * @author 谢福成
 * @see IFoodDrugUseRecordDAO
 * @see FoodDrugUseRecord
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
import com.lspro.dao.inter.IFoodDrugUseRecordDAO;
import com.lspro.pojo.FoodDrugUseRecord;


public class FoodDrugUseRecordDAOImpl implements IFoodDrugUseRecordDAO {
	
	private SessionFactory sf = null;
	private Session sess = null;
	private Transaction tx = null;
	private static String sql = "from FoodDrugUseRecord as fdur where fdur.startTime like :name or fdur.productName like :name or " +
			"fdur.manufacturer like :name or fdur.BatchNum like :name or fdur.dosage like :name or fdur.stopTime like :name";
	
	public FoodDrugUseRecordDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(service);
		sess = sf.openSession();
	}

	public boolean doCreate(FoodDrugUseRecord vo) throws Exception {
		// TODO Auto-generated method stub 
		try {
			tx = sess.beginTransaction();
			sess.persist(vo);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public boolean doUpdate(FoodDrugUseRecord vo) throws Exception {
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
			sess.delete(sess.load(FoodDrugUseRecord.class, id));
		 	tx.commit();
		 	return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public FoodDrugUseRecord findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			FoodDrugUseRecord frur = (FoodDrugUseRecord)sess.load(FoodDrugUseRecord.class, id);
			return frur;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public List<FoodDrugUseRecord> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {

			List<FoodDrugUseRecord> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //模糊查询
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public List<FoodDrugUseRecord> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		try {

			Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //分页查询
			query.setFirstResult((currentPage - 1 ) * lineSize);
			query.setMaxResults(lineSize);
			List<FoodDrugUseRecord> list = query.list();
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
