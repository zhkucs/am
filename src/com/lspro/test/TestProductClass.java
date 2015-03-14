package com.lspro.test;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.impl.ProductRecordDAOImpl;
import com.lspro.dao.inter.IProductRecordDAO;
import com.lspro.pojo.ProductionRecords;

public class TestProductClass {

	IProductRecordDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao = new ProductRecordDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 1;i<16;i++){
			ProductionRecords pro = new ProductionRecords();
			pro.setRoomNum(1000+i+"");
			pro.setRecordDate("2013-12-"+i);
			pro.setBirthNum(100);
			pro.setDeadNum(20);
			pro.setPutNum(20);
			pro.setInNum(20);
			pro.setRemainNum(80);
			pro.setNote("demotest");
			try {
				dao.doCreate(pro);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}

	@Test
	public void testUpdate() {
		ProductionRecords pro = new ProductionRecords();
		pro.setId(2);
		pro.setRoomNum("1002");
		pro.setRecordDate("2013-12-2");
		pro.setBirthNum(100);
		pro.setDeadNum(30);
		pro.setPutNum(10);
		pro.setInNum(0);
		pro.setRemainNum(80);
		pro.setNote("AAAAAAAAAAAAA");
		try {
			dao.doUpdate(pro);
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
			System.out.println(dao.findById(3).getRoomNum());
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
			List<ProductionRecords> list = dao.findAll("");
			for(ProductionRecords p : list) {
				System.out.println(p.getRoomNum());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<ProductionRecords> list = dao.findAll("",3,5);
			for(ProductionRecords p : list) {
				System.out.println(p.getRoomNum());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
