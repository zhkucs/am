package com.lspro.dao.impl;

/**
 * Desperation:
 * 此操作类实现了IProductADAO接口，用于动物检疫合格证明表(产品A)增删改查方法的实现<br>
 * @author 谢福成
 * @see IProductADAO
 * @see ProductA
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
import com.lspro.dao.inter.IProductADAO;
import com.lspro.pojo.ProductA;

public class ProductADAOImpl implements IProductADAO {
	
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql = "from ProductA as pa where pa.id like :name or pa.shipperName like :name or pa.phoneNum like :name or pa.productName like :name " +
			"or pa.number like :name or pa.addressName like :name or pa.destination like :name or pa.carrier like :name " +
			"or pa.carrierPhone like :name or pa.transportWay like :name or pa.transportId like :name or pa.note like :name " ;
	
	public ProductADAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry re = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(re);
		sess = sf.openSession();
	}

	public boolean doCreate(ProductA vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.save(vo); //把数据保存到数据库中。
		tx.commit();
		return true;
	}

	public boolean doUpdate(ProductA vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(ProductA.class, id));
		tx.commit();
		return true;
	}

	public ProductA findById(String id) throws Exception {
		// TODO Auto-generated method stub
		ProductA pro = (ProductA) sess.load(ProductA.class, id);
		return pro;
	}

	public List<ProductA> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<ProductA> list = sess.createQuery(hql).setString("name", "%" + keyWord + "%").list();
		return list;
	}

	public List<ProductA> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(hql).setString("name", "%" + keyWord + "%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<ProductA> list = query.list();
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
