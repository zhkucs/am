package com.lspro.dao.impl;
/**
 * Desperation:
 * 此操作类实现了IProductBDAO接口，用于动物检疫合格证明表(产品A)增删改查方法的实现<br>
 * @author 谢福成
 * @see IProductBDAO
 * @see ProductB
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

import com.lspro.dao.inter.IProductBDAO;
import com.lspro.pojo.ProductA;
import com.lspro.pojo.ProductB;

public class ProductBDAOImpl implements IProductBDAO {
	
	private Session sess;
	private SessionFactory sf;
	private Transaction tx;
	private String hql =  "from ProductB as pb where pb.id like :name or pb.shipperName like :name " +
			"or pb.productName like :name or pb.number like :name or pb.addressName like :name or pb.producter like :name " +
			"or pb.destination like :name or pb.Quarantinemarks like :name or pb.note like :name " ;
	
	public ProductBDAOImpl(){
		Configuration conf = new Configuration().configure();
		ServiceRegistry re = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		sf = conf.buildSessionFactory(re);
		sess = sf.openSession();
	}
	
	public boolean doCreate(ProductB vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.save(vo); //把数据保存到数据库中。
		tx.commit();
		return true;
	}

	public boolean doUpdate(ProductB vo) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.merge(vo);
		tx.commit();
		return true;
	}

	public boolean doDelete(String id) throws Exception {
		// TODO Auto-generated method stub
		tx = sess.beginTransaction();
		sess.delete(sess.load(ProductB.class, id));
		tx.commit();
		return true;
	}

	public ProductB findById(String id) throws Exception {
		// TODO Auto-generated method stub
		ProductB pro = (ProductB) sess.load(ProductB.class, id);
		return pro;
	}

	public List<ProductB> findAll(String keyWord) throws Exception {
		// TODO Auto-generated method stub
		List<ProductB> list = sess.createQuery(hql).setString("name", "%" + keyWord + "%").list();
		return list;
	}

	public List<ProductB> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		Query query =  sess.createQuery(hql).setString("name", "%" + keyWord + "%");
		query.setFirstResult((currentPage-1)*lineSize);
		query.setMaxResults(lineSize);
		List<ProductB> list = query.list();
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
