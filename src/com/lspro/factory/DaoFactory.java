package com.lspro.factory;

import com.lspro.dao.impl.IFarmDAO;
import com.lspro.dao.inter.FarmDAOImpl;

 /**
  * Desperation��
  * ����Ϊ������,���ڻ�ȡ���ģ��ľ��������.<br>
  * @author ����
  * @see IFarmDAO
  * @see FarmDAOImpl
  * @version 1.0
  */

public class DaoFactory {
	
	public static IFarmDAO getIFarmDaoInstance() {
		
		return new FarmDAOImpl();
	}
}
