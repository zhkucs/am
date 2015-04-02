package com.lspro.dao.impl;

/**
 * Desperation:
 * �˲�����ʵ����IFoodDrugUseRecordDAO�ӿڣ��������ϡ�������Ӽ�����ҩʹ�ü�¼����ɾ�Ĳ鷽����ʵ��<br>
 * @author л����
 * @see IFoodDrugUseRecordDAO
 * @see FoodDrugUseRecord
 * @version 2.0(ȥ�������е�try...catch��)
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
		tx = sess.beginTransaction();
		sess.persist(vo);
		tx.commit();
		return true;

		
	}

	public boolean doUpdate(FoodDrugUseRecord vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(FoodDrugUseRecord.class, id));
	 	tx.commit();
	 	return true;
	
	}

	public FoodDrugUseRecord findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		FoodDrugUseRecord frur = (FoodDrugUseRecord)sess.load(FoodDrugUseRecord.class, id);
		return frur;
	
	}

	public List<FoodDrugUseRecord> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<FoodDrugUseRecord> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //ģ����ѯ
		return list;

	}

	public List<FoodDrugUseRecord> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //��ҳ��ѯ
		query.setFirstResult((currentPage - 1 ) * lineSize);
		query.setMaxResults(lineSize);
		List<FoodDrugUseRecord> list = query.list();
		return list;
	
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		int record = sess.createQuery(sql).setString("name", "%" + keyWord + "%").list().size();  //��ȡ���ݵ���Ŀ
		return record;
	
	}
	
	public void close(){
		sess.close();
		sf.close();
	}

}
