package com.lspro.factory;

import com.lspro.dao.impl.IFarmDAO;
import com.lspro.dao.inter.FarmDAOImpl;

 /**
  * Desperation：
  * 此类为工厂类,用于获取相关模块的具体操作类.<br>
  * @author 阿呆
  * @see IFarmDAO
  * @see FarmDAOImpl
  * @version 1.0
  */

public class DaoFactory {
	
	public static IFarmDAO getIFarmDaoInstance() {
		
		return new FarmDAOImpl();
	}
}
