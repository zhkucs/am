package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IImmuneRecordDAO接口，用于生产记录数据表增删改查方法的实现<br>
 * @author 谢福成
 * @see IImmuneRecordDAO
 * @see ImmuneRecord
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

import com.lspro.dao.inter.IImmuneRecordDAO;
import com.lspro.pojo.ImmuneRecord;

public class ImmuneRecordDAOImpl implements IImmuneRecordDAO {
	
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private static String hql = "from ImmuneRecord as immune WHERE immune.immuneTime like :name or immune.roomNum like :name or " +
			"immune.remainNum like :name  ";
	
	public ImmuneRecordDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(service);
		sess = sf.openSession();
	}

	public boolean doCreate(ImmuneRecord vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.save(vo); //把数据保存到数据库中。
		tx.commit();
		return true;
	}

	public boolean doUpdate(ImmuneRecord vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(ImmuneRecord.class, id));
		tx.commit();
		return true;
	}

	public ImmuneRecord findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ImmuneRecord immune = (ImmuneRecord) sess.load(ImmuneRecord.class, id);
		return immune;
	}

	public List<ImmuneRecord> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<ImmuneRecord> list = sess.createQuery(hql).setString("name", "%" + keyWord + "%").list();
		return list;
	}

	public List<ImmuneRecord> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(hql).setString("name", "%" + keyWord + "%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<ImmuneRecord> list = query.list();
		return list;
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return sess.createQuery(hql).setString("name", "%" + keyWord + "%").list().size();
	}

	public void close() {
		// TODO Auto-generated method stub
		sess.close();
		sf.close();
	}

}
