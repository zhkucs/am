package com.lspro.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IAnimalBDAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.AnimalA;
import com.lspro.pojo.AnimalB;

public class TestAnimalBClass {
	IAnimalBDAO dao = null;
	@Before
	public void setUp() throws Exception {
		dao = DaoFactory.getIAnimalBDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		for(int i = 1;i<16;i++){
			AnimalB ab = new AnimalB();
			ab.setId("shengneixumu"+i);
			ab.setShipperName("PETER" + i);
			ab.setPhoneNum("1882625222"+i);
			ab.setAnimalSpecies("AA"+i);
			ab.setNumber("1000"+i+"ͷ");
			ab.setStartAddress("guangzhouzhongkai"+i);
			ab.setDestination("baiyunhaizhu"+i);
			ab.setUse("food"+i);
		 
			List<String> an1 = new ArrayList<String>();
			an1.add("qqq"+i+"1");
			an1.add("qqq"+i+"2");
			an1.add("qqq"+i+"3");
			an1.add("qqq"+i+"4");
			an1.add("qqq"+i+"5");
			an1.add("qqq"+i+"6");
			an1.add("qqq"+i+"7");
			an1.add("qqq"+i+"8");
			an1.add("qqq"+i+"9");
			ab.setAnimalId(an1);
			try {
				dao.doCreate(ab);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	@Test
	public void testUpdate(){
		AnimalB ab = new AnimalB();
		ab.setId("XUMUchang5");
		ab.setShipperName("PETER" );
		ab.setPhoneNum("1882625222");
		ab.setAnimalSpecies("AA456");
		ab.setNumber("1000ͷ");
		ab.setStartAddress("guangzhouzhongkai");
		ab.setDestination("baiyunhaizhu");
		ab.setUse("food");
 
		List<String> an1 = new ArrayList<String>();
		an1.add("zzz"+"1");
		an1.add("zzz"+"2");
		an1.add("zzz"+"3");
		an1.add("zzz"+"4");
		an1.add("zzz"+"5");
		an1.add("zzz"+"6");
		an1.add("zzz"+"7");
		an1.add("zzz"+"8");
		an1.add("zzz"+"9");
		ab.setAnimalId(an1);
		try {
			System.out.println(dao.doUpdate(ab));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.doDelete("shengneixumu5");
	}
	
	@Test
	public void testFindById() throws Exception{
		System.out.println(dao.findById("shengneixumu4").getId());
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
			List<AnimalB> list = dao.findAll("");
			for(int i = 0;i<list.size();i++){
				AnimalB aa =  list.get(i);
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
			List<AnimalB>  list = dao.findAll("",3,5);
			for(AnimalB p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
