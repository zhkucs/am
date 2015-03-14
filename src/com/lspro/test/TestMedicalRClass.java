package com.lspro.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IMedicalRecordDAO;
import com.lspro.factory.DaoFactory;
 
import com.lspro.pojo.MedicalRecord;

public class TestMedicalRClass {

	IMedicalRecordDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao =DaoFactory.getIMedicalRecordDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 1;i<16;i++){
			MedicalRecord med = new MedicalRecord();
			med.setMedicalTime("2015-3-"+i);
			med.setLivestockId("1123456789A"+i);
			med.setRoomNum("CCC"+i);
			med.setDateAge(i);
			med.setSickNum(20+i);
			med.setSickReason("qwerty"+i);
			med.setMedicalPeo("ZAXC"+i);
			Map<String,String> map = new HashMap<String, String>();
			map.put("sss"+i, "SSS"+i);
			med.setMedicine(map);
			med.setMedicalResult("TTTTTTTTTTT"+i);
			try {
				dao.doCreate(med);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	@Test
	public void testUpdate() {
		MedicalRecord med = new MedicalRecord();
		med.setId(2);
		med.setMedicalTime("2015-3-");
		med.setLivestockId("1123456789A");
		med.setRoomNum("CCC");
		med.setDateAge(55);
		med.setSickNum(20);
		med.setSickReason("qwerty");
		med.setMedicalPeo("ZAXC");
		Map<String,String> map = new HashMap<String, String>();
		map.put("sss", "SSS");
		med.setMedicine(map);
		med.setMedicalResult("TTTTTTTTTTT");
		try {
			dao.doUpdate(med);
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
			List<MedicalRecord> list = dao.findAll("");
			for(MedicalRecord p : list) {
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
			List<MedicalRecord> list = dao.findAll("",3,5);
			for(MedicalRecord p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
