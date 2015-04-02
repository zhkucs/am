package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IEpidemicMonitoringDAO接口，用于防疫监测记录基本数据表增删改查方法的实现<br>
 * @author 谢福成
 * @see IEpidemicMonitoringDAO
 * @see EpidemicMonitoring
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

import com.lspro.dao.inter.IEpidemicMonitoringDAO;
import com.lspro.pojo.EpidemicMonitoring;
import com.lspro.pojo.MedicalRecord;

public class EpidemicMonitoringDAOImpl implements IEpidemicMonitoringDAO {
	
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql ="from EpidemicMonitoring as epi where epi.samplingTime like :name or epi.roomNum like :name or epi.samplingNum like :name or " +
			"epi.monitoringName like :name or epi.monitoringStation like :name or epi.monitoringResult like :name or epi.disposalConditions like :name or epi.note like :name";

	public EpidemicMonitoringDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(service);
		sess = sf.openSession();
	}
	
	public boolean doCreate(EpidemicMonitoring vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo);
		tx.commit();
		return true;
	}

	public boolean doUpdate(EpidemicMonitoring vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(EpidemicMonitoring.class, id));
		tx.commit();
		return true;
	}

	public EpidemicMonitoring findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		EpidemicMonitoring med = (EpidemicMonitoring)sess.load(EpidemicMonitoring.class, id);
		return med;
	}

	public List<EpidemicMonitoring> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<EpidemicMonitoring> list = sess.createQuery(hql).setString("name", "%"+keyWord+"%").list();
		return list;
	}

	public List<EpidemicMonitoring> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Query query = sess.createQuery(hql).setString("name", "%"+keyWord+"%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<EpidemicMonitoring> list = query.list();
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
