package com.lspro.dao.inter;

/**
 * Description:
 * 此接口继承了IDAO接口,以便用于功能的扩展.<br>
 * @author 谢福成
 * @see IDAO
 * @see MedicalRecord
 * @version 1.0
 */

import com.lspro.pojo.MedicalRecord;

public interface IMedicalRecordDAO extends IDAO<MedicalRecord, Integer> {

}
