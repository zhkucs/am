package com.lspro.dao.inter;

/**
 * Description:
 * 此接口继承了IDAO接口,以便用于功能的扩展.<br>
 * @author 谢福成
 * @see IDAO
 * @see AnimalA
 * @version 1.0
 */

import com.lspro.pojo.AnimalA;

public interface IAnimalADAO extends IDAO<AnimalA, String> {

}
