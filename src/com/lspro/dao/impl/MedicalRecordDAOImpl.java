package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IMedicalRecordDAO接口，用于生产记录数据表增删改查方法的实现<br>
 * @author 谢福成
 * @see IMedicalRecordDAO
 * @see MedicalRecord
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

import com.lspro.dao.inter.IMedicalRecordDAO;
import com.lspro.pojo.MedicalRecord;

public class MedicalRecordDAOImpl implements IMedicalRecordDAO {

	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql ="from MedicalRecord as med where med.medicalTime like :name or med.LivestockId like :name or med.roomNum like :name or " +
			"med.dateAge like :name or med.sickNum like :name or med.sickReason like :name or med.medicalPeo like :name or med.medicalResult like :name";
	
	public MedicalRecordDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(service);
		sess = sf.openSession();
	}
	
	
	public boolean doCreate(MedicalRecord vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo);
		tx.commit();
		return true;
	}

	public boolean doUpdate(MedicalRecord vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(MedicalRecord.class, id));
		tx.commit();
		return true;
	}

	public MedicalRecord findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		MedicalRecord med = (MedicalRecord)sess.load(MedicalRecord.class, id);
		return med;
	}

	public List<MedicalRecord> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<MedicalRecord> list = sess.createQuery(hql).setString("name", "%"+keyWord+"%").list();
		return list;
	}

	public List<MedicalRecord> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Query query = sess.createQuery(hql).setString("name", "%"+keyWord+"%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<MedicalRecord> list = query.list();
		return list;
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return sess.createQuery(hql).setString("name", "%"+keyWord+"%").list().size();
	}

	public void close() {
		// TODO Auto-generated method stub
		sess.close();
		sf.close();
	}

}
