package com.lspro.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IProductADAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.AnimalA;
import com.lspro.pojo.ProductA;

public class TestProductAClass {
	IProductADAO dao = null;
	@Before
	public void setUp() throws Exception {
		dao = DaoFactory.getIProductADaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		for(int i = 1;i<16;i++){
			ProductA pa = new ProductA();
			pa.setId("changPingMc"+i);
			pa.setShipperName("PETER" + i);
			pa.setPhoneNum("1882625222"+i);
			pa.setProductName("dandandan"+i);
			pa.setNumber("1000"+i+"¸ö");
			pa.setAddressName("guangzhouzhongkai"+i);
			pa.setDestination("baiyunhaizhu"+i);
			pa.setCarrier("TOM"+i);
			pa.setCarrierPhone("1342351111"+i);
			pa.setTransportWay("huiji"+i);
			pa.setTransportId("BBAACC"+i);
			pa.setDisinfection(true);
			pa.setNote("adsssssssssssssssssssss"+i);	
			try {
				dao.doCreate(pa);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	@Test
	public void testUpdate(){
		ProductA pa = new ProductA();
		pa.setId("changPingMc5");
		pa.setShipperName("PETER");
		pa.setPhoneNum("1882625222");
		pa.setProductName("dandandan");
		pa.setNumber("1000¸ö");
		pa.setAddressName("guangzhouzhongkai");
		pa.setDestination("baiyunhaizhu");
		pa.setCarrier("TOM");
		pa.setCarrierPhone("1342351111");
		pa.setTransportWay("huiji");
		pa.setTransportId("BBAACC");
		pa.setDisinfection(true);
		pa.setNote("adsssssssssssssssssssss");	
		try {
			System.out.println(dao.doUpdate(pa));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.doDelete("changPingMc5");
	}
	
	@Test
	public void testFindById() throws Exception{
		System.out.println(dao.findById("changPingMc4").getId());
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
			List<ProductA> list = dao.findAll("15");
			for(int i = 0;i<list.size();i++){
				ProductA pa =  list.get(i);
				System.out.println( pa.getAddressName()+"----" + pa.getId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindAllByK(){
		try {
			List<ProductA>  list = dao.findAll("",3,5);
			for(ProductA p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
