package com.lspro.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IEpidemicMonitoringDAO;
import com.lspro.dao.inter.IMedicalRecordDAO;
import com.lspro.factory.DaoFactory;
 
import com.lspro.pojo.EpidemicMonitoring;
import com.lspro.pojo.MedicalRecord;

public class TestEpidemicMClass {

	IEpidemicMonitoringDAO dao = null;
	
	@Before
	public void setUp() throws Exception {
		dao =DaoFactory.getIEpidemicMonitoringDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		for(int i = 1;i<16;i++){
			EpidemicMonitoring epi = new EpidemicMonitoring();
			epi.setSamplingTime("2015-3-"+i);
			epi.setRoomNum("AAA"+i);
			epi.setSamplingNum(10+i);
			epi.setMonitoringName("AGK"+i);
			epi.setMonitoringStation("dbc"+i);
			epi.setMonitoringResult("KBV"+i);
			epi.setDisposalConditions("QVOD"+i);
			epi.setNote("LLLLL"+i);
			try {
				dao.doCreate(epi);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	@Test
	public void testUpdate() {
		EpidemicMonitoring epi = new EpidemicMonitoring();
		epi.setId(2);
		epi.setSamplingTime("2015-3-");
		epi.setRoomNum("AAA");
		epi.setSamplingNum(10);
		epi.setMonitoringName("AGK");
		epi.setMonitoringStation("dbc");
		epi.setMonitoringResult("KBV");
		epi.setDisposalConditions("QVOD");
		epi.setNote("LLLLL");
		try {
			dao.doUpdate(epi);
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
			System.out.println(dao.findById(3).getMonitoringStation());
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
			List<EpidemicMonitoring> list = dao.findAll("");
			for(EpidemicMonitoring p : list) {
				System.out.println(p.getDisposalConditions() );
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<EpidemicMonitoring> list = dao.findAll("",3,5);
			for(EpidemicMonitoring p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
