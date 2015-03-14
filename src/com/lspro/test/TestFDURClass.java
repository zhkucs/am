package com.lspro.test;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.impl.FoodDrugUseRecordDAOImpl;
import com.lspro.dao.impl.ProductRecordDAOImpl;
import com.lspro.dao.inter.IFoodDrugUseRecordDAO;
import com.lspro.dao.inter.IProductRecordDAO;
import com.lspro.pojo.FoodDrugUseRecord;
import com.lspro.pojo.ProductionRecords;

public class TestFDURClass {

	IFoodDrugUseRecordDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao = new FoodDrugUseRecordDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 0;i<15;i++){
			FoodDrugUseRecord fdur = new FoodDrugUseRecord();
			fdur.setStartTime("12-12-12");
			fdur.setProductName("AAA"+i);
			fdur.setManufacturer("BBB"+i);
			fdur.setBatchNum("CCC"+i);
			fdur.setDosage(100.0+i);
			fdur.setStopTime("DDD"+i);
			fdur.setNote("EEEEEEEEEEEEEEEE");
			try {
				dao.doCreate(fdur);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	@Test
	public void testUpdate() {
		FoodDrugUseRecord fdur = new FoodDrugUseRecord();
		fdur.setId(2);
		fdur.setStartTime("12-12-12");
		fdur.setProductName("AAA");
		fdur.setManufacturer("BBB");
		fdur.setBatchNum("CCC");
		fdur.setDosage(100.0);
		fdur.setStopTime("DDD");
		fdur.setNote("EEEEEEEEEEEEEEEE");
		try {
			dao.doUpdate(fdur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete(){
		try {
			dao.doDelete(16);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindById(){
		try {
			System.out.println(dao.findById(2).getManufacturer());
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
			List<FoodDrugUseRecord> list = dao.findAll("AAA");
			for(FoodDrugUseRecord p : list) {
				System.out.println(p.getStartTime()+"   " + p.getManufacturer() + "  " + p.getStopTime());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<FoodDrugUseRecord> list = dao.findAll("",3,5);
			for(FoodDrugUseRecord p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
