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
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.FarmMes;
import com.lspro.pojo.TechnicalPerson;

public class TestFramClass {
	IFarmDAO dao = null;
	@Before
	public void setUp() throws Exception {
		dao =  DaoFactory.getIFarmDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testFarmInsert() {
		for(int i = 0;i<15;i++){
			FarmMes mes = new FarmMes();
			mes.setFarmId("2222222222222222"+i);
			mes.setFarmName("demotest1");
			List<String> list = new ArrayList<String>();
			list.add("A");
			list.add("B");
			mes.setSpecies(list);
			mes.setFarmSize(300);
			mes.setLocation("zhongkai");
			mes.setLeader("weimingming");
			mes.setZipcode("500000");
			mes.setPhoneNum("123123123");
			List<TechnicalPerson> person = new ArrayList<TechnicalPerson>();
			TechnicalPerson p1 = new TechnicalPerson();
			p1.setWorkId("123");
			p1.setFarrierNum("asdfghj");
			p1.setProfessSkill("moumou");
			p1.setPhoneNum("987654");
			TechnicalPerson p2 = new TechnicalPerson();
			p2.setWorkId("456");
			p2.setFarrierNum("xzczxczxcz");
			p2.setProfessSkill("mou");
			p2.setPhoneNum("456789");
			person.add(p1);
			person.add(p2);
			mes.setPerson(person);
			mes.setCertificate("AA123456");
			List<String> envirEquip = new ArrayList<String>();
			envirEquip.add("AAA");
			envirEquip.add("BBB");
			mes.setEnvirEquip(envirEquip);
			mes.setFarmPhoto("photo.jpg");
			mes.setImmunePro("llllllllllllllaaaaaaaaaa");
			mes.setAccept(false);
			try {
				dao.doCreate(mes);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	@Test
	public void testUpdate(){
		FarmMes mes = new FarmMes();
		mes.setFarmId("111111111111111");
		mes.setFarmName("ÄãºÃ");
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		mes.setSpecies(list);
		mes.setFarmSize(300);
		mes.setLocation("zhongkai");
		mes.setLeader("weimingming");
		mes.setZipcode("500000");
		mes.setPhoneNum("123123123");
		List<TechnicalPerson> person = new ArrayList<TechnicalPerson>();
		TechnicalPerson p1 = new TechnicalPerson();
		p1.setWorkId("123");
		p1.setFarrierNum("asdfghj");
		p1.setProfessSkill("moumou");
		p1.setPhoneNum("987654");
		TechnicalPerson p2 = new TechnicalPerson();
		p2.setWorkId("456");
		p2.setFarrierNum("xzczxczxcz");
		p2.setProfessSkill("mou");
		p2.setPhoneNum("456789");
		person.add(p1);
		person.add(p2);
		mes.setPerson(person);
		mes.setCertificate("AA123456");
		List<String> envirEquip = new ArrayList<String>();
		envirEquip.add("AAA");
		envirEquip.add("BBB");
		mes.setEnvirEquip(envirEquip);
		mes.setFarmPhoto("photo.jpg");
		mes.setImmunePro("llllllllllllllbbbbbbbbbbbbb");
		mes.setAccept(false);
		try {
			System.out.println(dao.doUpdate(mes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			List list = dao.findAll("");
			for(int i = 0;i<list.size();i++){
				FarmMes farm = (FarmMes) list.get(i);
				System.out.println(farm.getFarmId() + farm.getFarmName() + farm.getCertificate());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
