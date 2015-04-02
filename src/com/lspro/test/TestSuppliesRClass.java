package com.lspro.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.ISuppliesDAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.MedicalRecord;
import com.lspro.pojo.Supplies;

public class TestSuppliesRClass {

	ISuppliesDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao =DaoFactory.getISuppliesDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 1;i<16;i++){
			Supplies sup = new Supplies();
			sup.setSuppliesId("ADSLL"+i);
			sup.setSuppliesName("zhongkai"+i);
			sup.setSuppliesPrice(100.0+i);
			sup.setProducter("xinji"+i);
			sup.setNumber(10000+i);
			sup.setReservePlace("guangdong"+i);
			sup.setFailSitution("dadada"+i);
			sup.setManagementstation("zhengfu"+i);
			sup.setHead("qwerrr"+i);
			sup.setValidDate("2013-12-1-2014-12-"+i);
			try {
				dao.doCreate(sup);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	@Test
	public void testUpdate() {
		int i = 0;
		Supplies sup = new Supplies();
		sup.setSuppliesId("ADSLL"+2);
		sup.setSuppliesName("zhongkai"+i);
		sup.setSuppliesPrice(100.0+i);
		sup.setProducter("xinji"+i);
		sup.setNumber(10000+i);
		sup.setReservePlace("guangdong"+i);
		sup.setFailSitution("dadada"+i);
		sup.setManagementstation("zhengfu"+i);
		sup.setHead("qwerrr"+i);
		sup.setValidDate("2013-12-1-2014-12-"+i);
		try {
			dao.doUpdate(sup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete(){
		try {
			dao.doDelete("ADSLL2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindById(){
		try {
			System.out.println(dao.findById("ADSLL"+3).getSuppliesId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetAllRecord(){
		try {
			System.out.println(dao.getAllrecord(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAll(){
		try {
			List<Supplies> list = dao.findAll("");
			for(Supplies p : list) {
				System.out.println(p.getSuppliesId() );
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<Supplies> list = dao.findAll("",3,5);
			for(Supplies p : list) {
				System.out.println(p.getSuppliesId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
