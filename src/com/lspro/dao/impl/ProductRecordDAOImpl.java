package com.lspro.dao.impl;

/**
 * Desperation:
 * �˲�����ʵ����IProductRecordDAO�ӿڣ�����������¼���ݱ���ɾ�Ĳ鷽����ʵ��<br>
 * @author л����
 * @see IProductRecordDAO
 * @see ProductionRecords
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
import com.lspro.dao.inter.IProductRecordDAO;
import com.lspro.pojo.ProductionRecords;


public class ProductRecordDAOImpl implements IProductRecordDAO {

	private SessionFactory sf = null;
	private Session sess = null;
	private Transaction tx = null;
	private static String sql = "from ProductionRecords as pro where pro.roomNum like :name or pro.recordDate like :name or pro.birthNum like :name or " +
			"pro.putNum like :name or pro.inNum like :name or pro.deadNum like :name or pro.remainNum like :name or pro.note like :name";
	
	public ProductRecordDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry service = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf =  conf.buildSessionFactory(service);
		sess = sf.openSession();
	}
	
	public boolean doCreate(ProductionRecords vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.persist(vo); //�����ݱ��浽���ݿ��С�
		tx.commit();
		return true;
	}

	public boolean doUpdate(ProductionRecords vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(ProductionRecords.class,id));
		tx.commit();
		return true;
	
	}

	public ProductionRecords findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ProductionRecords pr = (ProductionRecords) sess.load(ProductionRecords.class,id);
		return pr;

		
	}

	public List<ProductionRecords> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<ProductionRecords> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //ģ����ѯ
		return list;
	}

	public List<ProductionRecords> findAll(String keyWord, int currentPage,int lineSize) throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //��ҳ��ѯ
		query.setFirstResult((currentPage - 1 ) * lineSize);
		query.setMaxResults(lineSize);
		List<ProductionRecords> list = query.list();
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
