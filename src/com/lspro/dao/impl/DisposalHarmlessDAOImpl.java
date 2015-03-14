package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IDisposalHarmlessDAO接口，用于生产记录数据表增删改查方法的实现<br>
 * @author 谢福成
 * @see IDisposalHarmlessDAO
 * @see DisposalHarmless
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

import com.lspro.dao.inter.IDisposalHarmlessDAO;
import com.lspro.pojo.DisposalHarmless;
import com.lspro.pojo.EpidemicMonitoring;

public class DisposalHarmlessDAOImpl implements IDisposalHarmlessDAO {
	
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql ="from DisposalHarmless as disp where disp.disposalTime like :name or disp.number like :name or disp.disposalOrResult like :name or " +
			"disp.LivestockId like :name or disp.disposalMethod like :name or disp.disposalStation like :name or disp.note like :name";
	
	public DisposalHarmlessDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(service);
		sess = sf.openSession();
	}

	public boolean doCreate(DisposalHarmless vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo);
		tx.commit();
		return true;
	}

	public boolean doUpdate(DisposalHarmless vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(DisposalHarmless.class, id));
		tx.commit();
		return true;
	}

	public DisposalHarmless findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		DisposalHarmless dis = (DisposalHarmless)sess.load(DisposalHarmless.class, id);
		return dis;
	}

	public List<DisposalHarmless> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<DisposalHarmless> list = sess.createQuery(hql).setString("name", "%"+keyWord+"%").list();
		return list;
	}

	public List<DisposalHarmless> findAll(String keyWord, int currentPage,
			int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Query query = sess.createQuery(hql).setString("name", "%"+keyWord+"%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<DisposalHarmless> list = query.list();
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
