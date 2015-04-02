package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IAnimalADAO接口，用于动物检疫合格证明表(动物A)增删改查方法的实现<br>
 * @author 谢福成
 * @see IAnimalADAO
 * @see AnimalA
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

import com.lspro.dao.inter.IAnimalADAO;
import com.lspro.pojo.AnimalA;
import com.lspro.pojo.MedicalRecord;
 

public class AnimalADAOImpl implements IAnimalADAO {
	
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql ="from AnimalA as aa where aa.id like :name or aa.shipperName like :name or aa.phoneNum like :name or aa.animalSpecies like :name " +
			"or aa.number like :name or aa.startAddress like :name or aa.destination like :name or aa.use like :name or aa.carrier like :name " +
			"or aa.carrierPhone like :name or aa.transportWay like :name or aa.transportId like :name or aa.note like :name " ;
	
	public AnimalADAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(registry);
		sess = sf.openSession();
	}

	public boolean doCreate(AnimalA vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo);
		tx.commit();
		return true;
	}

	public boolean doUpdate(AnimalA vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(AnimalA.class, id));
		tx.commit();
		return true;
	}

	public AnimalA findById(String id) throws Exception {
		// TODO Auto-generated method stub
		AnimalA aa = (AnimalA) sess.load(AnimalA.class,id);
		return aa;
	}

	public List<AnimalA> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<AnimalA> list = sess.createQuery(hql).setString("name", "%"+keyWord+"%").list();
		return list;
	}

	public List<AnimalA> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = sess.createQuery(hql).setString("name", "%"+keyWord+"%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<AnimalA> list = query.list();
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
