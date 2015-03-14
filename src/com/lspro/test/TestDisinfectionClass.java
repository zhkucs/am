package com.lspro.test;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.impl.DisinfectionRecordDAOImpl;
import com.lspro.dao.impl.ProductRecordDAOImpl;
import com.lspro.dao.inter.IDisinfectionRecordDAO;
import com.lspro.dao.inter.IProductRecordDAO;
import com.lspro.pojo.DisinfectionRecord;
import com.lspro.pojo.ProductionRecords;

public class TestDisinfectionClass {

	IDisinfectionRecordDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao = new DisinfectionRecordDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 1;i<16;i++){
			DisinfectionRecord dis = new DisinfectionRecord();
			dis.setDisinfectioDose(100.0+i);
			dis.setDisinfectionName("AAA"+i);
			dis.setDisinfectionTime("2015-3-"+i);
			dis.setMethod("VVV"+i);
			dis.setPlace("SSS"+i);
			dis.setSign("GGG"+i);
			try {
				dao.doCreate(dis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

	@Test
	public void testUpdate() {
		DisinfectionRecord dis = new DisinfectionRecord();
		dis.setId(2);
		dis.setDisinfectioDose(100.9);
		dis.setDisinfectionName("AAA");
		dis.setDisinfectionTime("2015-3-20");
		dis.setMethod("VVV");
		dis.setPlace("SSS");
		dis.setSign("GGG");
		try {
			dao.doUpdate(dis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete(){
		try {
			dao.doDelete(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindById(){
		try {
			System.out.println(dao.findById(3).getSign());
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
			List<DisinfectionRecord> list = dao.findAll("");
			for(DisinfectionRecord p : list) {
				System.out.println(p.getMethod());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<DisinfectionRecord> list = dao.findAll("",3,5);
			for(DisinfectionRecord p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
