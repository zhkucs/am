package com.lspro.factory;

import com.lspro.dao.impl.DisinfectionRecordDAOImpl;
import com.lspro.dao.impl.DisposalHarmlessDAOImpl;
import com.lspro.dao.impl.EpidemicMonitoringDAOImpl;
import com.lspro.dao.impl.FarmDAOImpl;
import com.lspro.dao.impl.FoodDrugUseRecordDAOImpl;
import com.lspro.dao.impl.ImmuneRecordDAOImpl;
import com.lspro.dao.impl.MedicalRecordDAOImpl;
import com.lspro.dao.impl.ProductRecordDAOImpl;
import com.lspro.dao.inter.IDisinfectionRecordDAO;
import com.lspro.dao.inter.IDisposalHarmlessDAO;
import com.lspro.dao.inter.IEpidemicMonitoringDAO;
import com.lspro.dao.inter.IFarmDAO;
import com.lspro.dao.inter.IFoodDrugUseRecordDAO;
import com.lspro.dao.inter.IImmuneRecordDAO;
import com.lspro.dao.inter.IMedicalRecordDAO;
import com.lspro.dao.inter.IProductRecordDAO;

 /**
  * Desperation��
  * ����Ϊ������,���ڻ�ȡ���ģ��ľ��������.<br>
  * @author ����
  * @see IFarmDAO
  * @see FarmDAOImpl
  * @version 2.0(��������7����ȡ���������ķ���)
  */

public class DaoFactory {
	
	public static IFarmDAO getIFarmDaoInstance() {
		
		return new FarmDAOImpl();
	}
	
	public static IProductRecordDAO getIProductRecordDaoInstance() {
		
		return new ProductRecordDAOImpl();
	}
	
	public static IFoodDrugUseRecordDAO getIFoodDrugUseRecordDaoInstance() {
		
		return new FoodDrugUseRecordDAOImpl();
	}
	
	public static IDisinfectionRecordDAO getIDisinfectionRecordDaoInstance() {
		return new DisinfectionRecordDAOImpl();
	}
	
	public static IImmuneRecordDAO getIImmuneRecordDaoInstance(){
		return new ImmuneRecordDAOImpl();
	}
	
	public static IMedicalRecordDAO getIMedicalRecordDaoInstance(){
		return new MedicalRecordDAOImpl();
	}
	
	public static IEpidemicMonitoringDAO getIEpidemicMonitoringDaoInstance(){
		return new EpidemicMonitoringDAOImpl();
	}
	
	public static IDisposalHarmlessDAO getIDisposalHarmlessDaoInstance(){
		return new DisposalHarmlessDAOImpl();
	}
}
