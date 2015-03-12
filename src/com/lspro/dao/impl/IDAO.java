package com.lspro.dao.impl;

import java.util.List;
/**
 * Description:
 * �˽ӿ�Ϊ����ģ��ӿ���ĸ���.�����ṩ��������ɾ�Ĳ鹦���Լ���ȡȫ����¼���ķ���<br>
 * @author л����
 * @param <T>  pojo��
 * @param <K>  ���ݿ�������������
 * @version 1.0
 */
public interface IDAO<T, K> {
	
	/**
	 * ��ҳ����������ӵ����ݿ���
	 * @param vo ����Ҫ������pojo��
	 * @return <tt>true</tt>������ݲ������ݿ�ɹ��򷵻�true;
	 * @throws hibernate�����쳣
	 */
	public boolean doCreate(T vo) throws Exception;

	/**
	 * �����ݿ�����Ӧ�����ݽ����޸�
	 * @param vo ����Ҫ������pojo��
	 * @return	<tt>true</tt>���vo���޸ĳɹ��򷵻�true;
	 * @throws hibernate�����쳣
	 */
	public boolean doUpdate(T vo) throws Exception;

	/**
	 * ɾ��ͨ��id��ѯ�õ�������
	 * @param id ���ݿ�ı�ʶ����
	 * @return	<tt>true</tt>���ͨ��id�ҵ���Ӧ���ݺ�ɾ���ɹ��򷵻�true;
	 * @throws  hibernate�����쳣
	 */
	public boolean doDelete(K id) throws Exception;

	/**
	 * ͨ��id��ѯ��Ӧ������.
	 * @param id ���ݿ�ı�ʶ����
	 * @return <tt>pojo����ʵ��</tt>���ͨ��id�ҵ���Ӧ�������򷵻ظ�����;
	 * @throws hibernate�����쳣
	 */
	public T findById(K id) throws Exception;
	
	/**
	 * ͨ���ؼ��ֲ�ѯ�����йص�����
	 * @param keyWord ģ����ѯ�Ĺؼ���
	 * @return  <tt>List����</tt> ģ����ѯ���ؽ��
	 * @throws hibernate�����쳣
	 */
	public List<T> findAll(String keyWord) throws Exception;
	
	/**
	 * ��ҳ��ѯ��ȡ����
	 * @param keyWord ģ����ѯ�Ĺؼ���
	 * @param currentPage  ��ҳ��ѯ�е�ǰҳ��ҳ��
	 * @param lineSize	   ��ҳ��ѯ�е�ǰҳ������Ҫ��ʾ��������Ŀ
	 * @return	<tt>List����</tt> ģ����ѯ���ؽ��
	 * @throws hibernate�����쳣
	 */

	public List<T> findAll(String keyWord, int currentPage, int lineSize)throws Exception;

	/**
	 * ��ȡ���Ϲؼ��ֵ�ȫ�����ݵ���Ŀ.
	 * @param keyWord ģ����ѯ�Ĺؼ���
	 * @return  <tt>Integer</tt> ���ݿ������ݵ�����
	 * @throws hibernate�����쳣
	 */
	public Integer getAllrecord(String keyWord) throws Exception;
}
