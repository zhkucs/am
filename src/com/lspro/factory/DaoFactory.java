package com.lspro.factory;

import com.lspro.dao.impl.*;
import com.lspro.dao.inter.*;

 /**
  * Desperation：
  * 此类为工厂类,用于获取相关模块的具体操作类.<br>
  * @author 阿呆
  * @version 4.0(获取方法增加至13个)
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
	
	public static ISuppliesDAO getISuppliesDaoInstance(){
		return new SuppliesDAOImpl();
	}
	
	public static IAnimalADAO getIAnimalADaoInstance(){
		return new AnimalADAOImpl();
	}
	
	public static IAnimalBDAO getIAnimalBDaoInstance(){
		return new AnimalBDAOImpl();
	}
	
	public static IProductADAO getIProductADaoInstance(){
		return new ProductADAOImpl();
	}
	
	public static IProductBDAO getIProductBDaoInstance(){
		return new ProductBDAOImpl();
	}
}
