package com.lspro.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IFarmDAO;
import com.lspro.dao.inter.IImmuneRecordDAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.FarmMes;
import com.lspro.pojo.ImmuneRecord;
import com.lspro.pojo.TechnicalPerson;
import com.lspro.pojo.Vaccine;

public class TestImmuneClass {
	IImmuneRecordDAO dao = null;
	@Before
	public void setUp() throws Exception {
		dao =  DaoFactory.getIImmuneRecordDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao.close();
	}

	@Test
	public void testInsert() {
	for(int i = 1;i<16;i++){
		//int i = 1;
			 ImmuneRecord imm = new ImmuneRecord();
			 imm.setImmuneTime("2015-3-"+i);
			 imm.setNote("ASDFGHJKL"+i);
			 imm.setRemainNum(200+i);
			 imm.setRoomNum("AAA");
			 Vaccine vac1 = new Vaccine();
			 vac1.setImmuneDosage(100.0+i);
			 vac1.setImmuneMethod("×¢Éä1");
			 vac1.setImmuneNum(100+i);
			 vac1.setImmunePeople("QQQ"+i);
			 vac1.setVaccineName("uuu"+i);
			 vac1.setVaccineProducers("zhongkai"+i);
			 vac1.setVaccineValidTime("2013456789A"+i);
			 Vaccine vac2 = new Vaccine();
			 vac2.setImmuneDosage(150.0+i);
			 vac2.setImmuneMethod("×¢Éä2");
			 vac2.setImmuneNum(150+i);
			 vac2.setImmunePeople("QQQ2"+i);
			 vac2.setVaccineName("uuu2"+i);
			 vac2.setVaccineProducers("zhongkai2"+i);
			 vac2.setVaccineValidTime("2013456789B"+i);
			 imm.getVaccineMes().add(vac1);
			 imm.getVaccineMes().add(vac2);
			 try {
				dao.doCreate(imm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	}
	
	@Test
	public void testUpdate(){
		 ImmuneRecord imm = new ImmuneRecord();
		 imm.setId(1);
		 imm.setImmuneTime("2015-3-31");
		 imm.setNote("ASDFGHJKL");
		 imm.setRemainNum(200);
		 imm.setRoomNum("AAA");
		 Vaccine vac1 = new Vaccine();
		 vac1.setImmuneDosage(100.0);
		 vac1.setImmuneMethod("×¢Éä5");
		 vac1.setImmuneNum(100);
		 vac1.setImmunePeople("YYY");
		 vac1.setVaccineName("uuu");
		 vac1.setVaccineProducers("zhongkai222");
		 vac1.setVaccineValidTime("2013456789C");
		 Vaccine vac2 = new Vaccine();
		 vac2.setImmuneDosage(150.0);
		 vac2.setImmuneMethod("×¢Éä6");
		 vac2.setImmuneNum(150);
		 vac2.setImmunePeople("YYY");
		 vac2.setVaccineName("uuu2");
		 vac2.setVaccineProducers("zhongkai333");
		 vac2.setVaccineValidTime("2013456789D");
		 imm.getVaccineMes().add(vac1);
		 imm.getVaccineMes().add(vac2);
		try {
			System.out.println(dao.doUpdate(imm));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete(){
		try {
			System.out.println(dao.doDelete(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindById(){
		try {
			System.out.println(dao.findById(2).getVaccineMes().get(1).getVaccineName());
		} catch (Exception e) {
			// TODO: handle exception
		}
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
			 List<ImmuneRecord> list = dao.findAll("");
			 for(ImmuneRecord imm : list) {
				 System.out.println(imm.getVaccineMes().get(0).getVaccineProducers());
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFy(){
		try {
			 List<ImmuneRecord> list = dao.findAll("", 3, 5);
			 for(ImmuneRecord imm : list) {
				 System.out.println(imm.getVaccineMes().get(0).getVaccineProducers() + imm.getRoomNum());
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
