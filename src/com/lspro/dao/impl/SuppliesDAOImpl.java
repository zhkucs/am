package com.lspro.dao.impl;

/**
 * Desperation:
 * �˲�����ʵ����ISuppliesDAO�ӿڣ��������ʴ���������Ϣ���ݱ���ɾ�Ĳ鷽����ʵ��<br>
 * @author л����
 * @see ISuppliesDAO
 * @see Supplies
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

import com.lspro.dao.inter.ISuppliesDAO;
import com.lspro.pojo.ProductionRecords;
import com.lspro.pojo.Supplies;

public class SuppliesDAOImpl implements ISuppliesDAO {

	private SessionFactory sf = null;
	private Session sess = null;
	private Transaction tx = null;
	private static String hql = "from Supplies as sup where sup.suppliesId like :name or sup.suppliesName like :name or" +
			" sup.suppliesPrice like :name or sup.producter like :name or sup.number like :name or sup.validDate like :name or " +
			"sup.reservePlace like :name or sup.failSitution like :name or sup.managementstation like :name";
	
	public SuppliesDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf =  conf.buildSessionFactory(service);
		sess = sf.openSession();
	}
	
	public boolean doCreate(Supplies vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo); //�����ݱ��浽���ݿ��С�
		tx.commit();
		return true;
	}

	public boolean doUpdate(Supplies vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(Supplies.class,id));
		tx.commit();
		return true;
	}

	public Supplies findById(String id) throws Exception {
		// TODO Auto-generated method stub
		Supplies sup = (Supplies) sess.load(Supplies.class,id);
		return sup;
	}

	public List<Supplies> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<Supplies> list =  sess.createQuery(hql).setString("name", "%" + keyWord + "%").list() ; //ģ����ѯ
		return list;
	}

	public List<Supplies> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(hql).setString("name", "%" + keyWord + "%");  //��ҳ��ѯ
		query.setFirstResult((currentPage - 1 ) * lineSize);
		query.setMaxResults(lineSize);
		List<Supplies> list = query.list();
		return list; 
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		int record = sess.createQuery(hql).setString("name", "%" + keyWord + "%").list().size();  //��ȡ���ݵ���Ŀ
		return record;
	}
	
	public void close(){
		sess.close();
		sf.close();
	}

}
