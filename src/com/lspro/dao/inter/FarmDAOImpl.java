package com.lspro.dao.inter;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.lspro.dao.impl.IFarmDAO;
import com.lspro.pojo.FarmMes;

/**
 * Desperation:
 * �˲�����ʵ����IFarmDAO�ӿڣ�������ɾ�Ĳ鷽����ʵ��<br>
 * @author ����
 * @see IFarmDAO
 * @see FarmMes
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
		tx = sess.beginTransaction();
	}
	

	public boolean doCreate(FarmMes vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			sess.save(vo); //�����ݱ��浽���ݿ��С�
			tx.commit();
			this.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}


	public boolean doUpdate(FarmMes vo) throws Exception {
		// TODO Auto-generated method stub
		try {
			sess.merge(vo);  //�޸�����
			tx.commit();
			FarmMes mes = (FarmMes) sess.get(FarmMes.class, vo.getFarmId());
			this.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}	
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			FarmMes mes = (FarmMes) sess.load(FarmMes.class, id);  //ɾ������
			sess.delete(mes);
			this.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} 
	}

	public FarmMes findById(String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			FarmMes mes = (FarmMes) sess.load(FarmMes.class, id);  //��������
			this.close();
			return mes;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public List<FarmMes> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {
			List<FarmMes> list =  sess.createQuery(sql).setString("name", "%" + keyWord + "%").list() ; //ģ����ѯ
			this.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public List<FarmMes> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			Query query =  sess.createQuery(sql).setString("name", "%" + keyWord + "%");  //��ҳ��ѯ
			query.setFirstResult((currentPage - 1 ) * lineSize);
			query.setMaxResults(lineSize);
			List<FarmMes> list = query.list();
			this.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}

	public Integer getAllrecord(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		try {
			int record = sess.createQuery(sql).setString("name", "%" + keyWord + "%").list().size();  //��ȡ���ݵ���Ŀ
			this.close();
			return record;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
	/**
	 * �ر���������
	 */
	public void close(){
		sess.close();
		sf.close();
	}

}
