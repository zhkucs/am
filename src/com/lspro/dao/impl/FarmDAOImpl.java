package com.lspro.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.lspro.dao.inter.IFarmDAO;
import com.lspro.pojo.FarmMes;

/**
 * Desperation:
 * �˲�����ʵ����IFarmDAO�ӿڣ�������ɾ�Ĳ鷽����ʵ��<br>
 * @author ����
 * @see IFarmDAO
 * @see FarmMes
 * @version 2.0(����ɾ�Ĳ��close����ȥ�����ڵ�������ʹ�ü��ɣ�ͬʱTransaction��ȡ������ÿ�����ܷ����У��������ڹ��췽��,�Լ�ȥ��ÿ�����ܷ����е�try...catch)
 */

public class FarmDAOImpl implements IFarmDAO{
	/**
	 * �������ݵĳ־û��Ĳ����Լ�����Ĵ���
	 */
	private SessionFactory sf = null;
	private Session sess = null;
	private Transaction tx = null;
	private static String sql = "from FarmMes as farm where farm.farmId like :name or farm.farmName like :name or farm.location like :name or " +
			"farm.phoneNum like :name or farm.ImmunePro like :name or farm.certificate like :name";
	
	/**
	 *  �޲ι��취������ʵ����SessionFactory,Session,Transaction����,�Ա���ɾ�Ĳ鹦�ܵ�ʵ��.
	 */
	public FarmDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(serviceRegistry);
		sess = sf.openSession();
	}
	

	public boolean doCreate(FarmMes vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.save(vo); //�����ݱ��浽���ݿ��С�
		tx.commit();
		return true;
	}


	public boolean doUpdate(FarmMes vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);  //�޸�����
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		FarmMes mes = (FarmMes) sess.load(FarmMes.class, id);  //ɾ������
		sess.delete(mes);
		return true;
	}

	public FarmMes findById(String id) throws Exception {
		// TODO Auto-generated method stub
		FarmMes mes = (FarmMes) sess.load(FarmMes.class, id);  //��������
		return mes;
		
	}

	public List<FarmMes> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<FarmMes> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //ģ����ѯ
		return list;	
	}

	public List<FarmMes> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //��ҳ��ѯ
		query.setFirstResult((currentPage - 1 ) * lineSize);
		query.setMaxResults(lineSize);
		List<FarmMes> list = query.list();
		return list;		
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		int record = sess.createQuery(sql).setString("name", "%" + keyWord + "%").list().size();  //��ȡ���ݵ���Ŀ
		return record;
		
	}
	
	/**
	 * �ر���������
	 */
	public void close(){
		sess.close();
		sf.close();
	}

}
