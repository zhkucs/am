package com.lspro.test;


import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IAnimalADAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.AnimalA;

public class TestAnimalAClass {
	IAnimalADAO dao = null;
	@Before
	public void setUp() throws Exception {
		dao = DaoFactory.getIAnimalADaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		for(int i = 1;i<16;i++){
			AnimalA aa = new AnimalA();
			aa.setId("XUMUchang"+i);
			aa.setShipperName("PETER" + i);
			aa.setPhoneNum("1882625222"+i);
			aa.setAnimalSpecies("AA"+i);
			aa.setNumber("1000"+i+"ͷ");
			aa.setStartAddress("guangzhouzhongkai"+i);
			aa.setDestination("baiyunhaizhu"+i);
			aa.setUse("food"+i);
			aa.setCarrier("TOM"+i);
			aa.setCarrierPhone("1342351111"+i);
			aa.setTransportWay("huiji"+i);
			aa.setTransportId("BBAACC"+i);
			aa.setDisinfection(true);
			aa.setNote("adsssssssssssssssssssss"+i);
			List<String> an1 = new ArrayList<String>();
			an1.add("xxx"+i+"1");
			an1.add("xxx"+i+"2");
			an1.add("xxx"+i+"3");
			an1.add("xxx"+i+"4");
			an1.add("xxx"+i+"5");
			an1.add("xxx"+i+"6");
			an1.add("xxx"+i+"7");
			an1.add("xxx"+i+"8");
			an1.add("xxx"+i+"9");
			aa.setAnimalId(an1);
			try {
				dao.doCreate(aa);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	@Test
	public void testUpdate(){
		AnimalA aa = new AnimalA();
		aa.setId("XUMUchang");
		aa.setShipperName("PETER" );
		aa.setPhoneNum("1882625222");
		aa.setAnimalSpecies("AA456");
		aa.setNumber("1000ͷ");
		aa.setStartAddress("guangzhouzhongkai");
		aa.setDestination("baiyunhaizhu");
		aa.setUse("food");
		aa.setCarrier("TOM");
		aa.setCarrierPhone("1342351111");
		aa.setTransportWay("huiji");
		aa.setTransportId("BBAACC");
		aa.setDisinfection(true);
		aa.setNote("adsssssssssssssssssssss");
		List<String> an1 = new ArrayList<String>();
		an1.add("xxx"+"1");
		an1.add("xxx"+"2");
		an1.add("xxx"+"3");
		an1.add("xxx"+"4");
		an1.add("xxx"+"5");
		an1.add("xxx"+"6");
		an1.add("xxx"+"7");
		an1.add("xxx"+"8");
		an1.add("xxx"+"9");
		aa.setAnimalId(an1);
		try {
			System.out.println(dao.doUpdate(aa));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.doDelete("XUMUchang");
	}
	
	@Test
	public void testFindById() throws Exception{
		System.out.println(dao.findById("XUMUchang1").getId());
	}
	
	
	@Test
	public void testAllrecord(){
		try {
			System.out.println(dao.getAllrecord(""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testfindAll(){
		try {
			List<AnimalA> list = dao.findAll("");
			for(int i = 0;i<list.size();i++){
				AnimalA aa =  list.get(i);
				System.out.println( aa.getAnimalSpecies() + aa.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<AnimalA>  list = dao.findAll("",3,5);
			for(AnimalA p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
