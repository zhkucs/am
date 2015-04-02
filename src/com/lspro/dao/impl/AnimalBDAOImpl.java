package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IAnimalBDAO接口，用于动物检疫合格证明表(动物B)增删改查方法的实现<br>
 * @author 谢福成
 * @see IAnimalBDAO
 * @see AnimalB
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
import com.lspro.dao.inter.IAnimalBDAO;
import com.lspro.pojo.AnimalB;

public class AnimalBDAOImpl implements IAnimalBDAO {
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql = "from AnimalB as ab where ab.id like :name or ab.shipperName like :name or ab.phoneNum like :name or ab.animalSpecies like :name " +
			"or ab.number like :name or ab.startAddress like :name or ab.destination like :name or ab.use like :name  ";
	
	public AnimalBDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry re = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(re);
		sess = sf.openSession();
	}
	
	public boolean doCreate(AnimalB vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo);
		tx.commit();
		return true;
	}

	public boolean doUpdate(AnimalB vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(AnimalB.class, id));
		tx.commit();
		return true;
	}

	public AnimalB findById(String id) throws Exception {
		// TODO Auto-generated method stub
		AnimalB aa = (AnimalB) sess.load(AnimalB.class,id);
		return aa;
	}

	public List<AnimalB> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<AnimalB> list = sess.createQuery(hql).setString("name", "%"+keyWord+"%").list();
		return list;
	}

	public List<AnimalB> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = sess.createQuery(hql).setString("name", "%"+keyWord+"%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<AnimalB> list = query.list();
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
