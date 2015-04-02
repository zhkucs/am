package com.lspro.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lspro.dao.inter.IProductBDAO;
import com.lspro.factory.DaoFactory;
import com.lspro.pojo.ProductB;

public class TestProductBClass {
	IProductBDAO dao = null;
	@Before
	public void setUp() throws Exception {
		dao = DaoFactory.getIProductBDaoInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		for(int i = 1;i<16;i++){
			ProductB pa = new ProductB();
			pa.setId("changPingMc"+i);
			pa.setShipperName("PETER" + i);
			pa.setProducter("guangdong"+i);
			pa.setProductName("dandandan"+i);
			pa.setNumber("1000"+i+"¸ö");
			pa.setAddressName("guangzhouzhongkai"+i);
			pa.setDestination("baiyunhaizhu"+i);
			pa.setQuarantinemarks("guang0000000"+i);
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
		ProductB pa = new ProductB();
		pa.setId("changPingMc5");
		pa.setShipperName("PETER" );
		pa.setProducter("guangdong");
		pa.setProductName("dandandan");
		pa.setNumber("1000¸ö");
		pa.setAddressName("guangzhouzhongkai");
		pa.setDestination("baiyunhaizhu");
		pa.setQuarantinemarks("guang0000000");
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
			List<ProductB> list = dao.findAll("15");
			for(int i = 0;i<list.size();i++){
				ProductB pa =  list.get(i);
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
			List<ProductB>  list = dao.findAll("",3,5);
			for(ProductB p : list) {
				System.out.println(p.getId());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
