package com.lspro.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IDisposalHarmlessDAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.DisposalHarmless;
import com.lspro.pojo.MedicalRecord;

public class TestDisposalHClass {

	IDisposalHarmlessDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao =DaoFactory.getIDisposalHarmlessDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 1;i<16;i++){
			DisposalHarmless dis = new DisposalHarmless();
			dis.setDisposalTime("2013-11-"+i);
			dis.setNumber(10+i);
			dis.setDisposalOrResult("DEAD"+i);
			dis.setLivestockId("14452138A"+i);
			dis.setDisposalMethod("GqOGOGO"+i);
			dis.setDisposalStation("qwerrr"+i);
			dis.setNote("AAAAAAAAAAA"+i);
			
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
		DisposalHarmless dis = new DisposalHarmless();
		dis.setId(2);
		dis.setDisposalTime("2013-11-");
		dis.setNumber(10);
		dis.setDisposalOrResult("DEAD");
		dis.setLivestockId("14452138A");
		dis.setDisposalMethod("GqOGOGO");
		dis.setDisposalStation("qwerrr");
		dis.setNote("AAAAAAAAAAA");
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
			System.out.println(dao.findById(3).getLivestockId());
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
			List<DisposalHarmless> list = dao.findAll("");
			for(DisposalHarmless p : list) {
				System.out.println(p.getLivestockId() );
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<DisposalHarmless> list = dao.findAll("",3,5);
			for(DisposalHarmless p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
