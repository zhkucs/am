package com.lspro.dao.impl;

/**
 * Desperation:
 * �˲�����ʵ����IDisinfectionRecordDAO�ӿڣ�����������¼���ݱ���ɾ�Ĳ鷽����ʵ��<br>
 * @author л����
 * @see IDisinfectionRecordDAO
 * @see DisinfectionRecord
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

import com.lspro.dao.inter.IDisinfectionRecordDAO;
import com.lspro.pojo.DisinfectionRecord;

public class DisinfectionRecordDAOImpl implements IDisinfectionRecordDAO {

	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private static String hql = "from DisinfectionRecord as dis where dis.disinfectionTime like :name or dis.place like :name or " +
			"dis.disinfectionName like :name or dis.disinfectioDose like :name or dis.method like :name or dis.sign like :name";
 
	
	
	public DisinfectionRecordDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(service);
		sess = sf.openSession();
	}
	
	public boolean doCreate(DisinfectionRecord vo) throws Exception {
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

	public boolean doUpdate(DisinfectionRecord vo) throws Exception {
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
			sess.delete(sess.load(DisinfectionRecord.class, id));
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public DisinfectionRecord findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			DisinfectionRecord dis =(DisinfectionRecord) sess.load(DisinfectionRecord.class, id);
			return dis;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public List<DisinfectionRecord> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<DisinfectionRecord> list = sess.createQuery(hql).setString("name", "%" + keyWord + "%").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}

	public List<DisinfectionRecord> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		try {
			Query query = sess.createQuery(hql).setString("name", "%"+keyWord+"%");
			query.setFirstResult((currentPage-1)*lineSize);
			query.setMaxResults(lineSize);
			List<DisinfectionRecord> list = query.list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {
			return sess.createQuery(hql).setString("name", "%"+keyWord+"%").list().size();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
 
	}

	public void close() {
		// TODO Auto-generated method stub
		sess.close();
		sf.close();
		
	}

}
