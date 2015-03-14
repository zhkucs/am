package com.lspro.pojo;

/**
 * Description:
 * ���������޺��������¼�������ݱ�<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
 * @version 1.0
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="���������޺��������¼��")
public class DisposalHarmless {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="��������")
	private String disposalTime;	//��������
	@Column(name="����")
	private Integer number;		//����
	@Column(name="���������ԭ��")
	private String disposalOrResult;	//���������ԭ��
	@Column(name="���ݱ�ʶ����")
	private String LivestockId;	//���ݱ�ʶ����
	@Column(name="������")
	private String disposalMethod;	//������
	@Column(name="����λ")
	private String disposalStation;	//����λ
	@Column(name="��ע")		
	private String note;	//��ע
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisposalTime() {
		return disposalTime;
	}
	public void setDisposalTime(String disposalTime) {
		this.disposalTime = disposalTime;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDisposalOrResult() {
		return disposalOrResult;
	}
	public void setDisposalOrResult(String disposalOrResult) {
		this.disposalOrResult = disposalOrResult;
	}
	public String getLivestockId() {
		return LivestockId;
	}
	public void setLivestockId(String livestockId) {
		LivestockId = livestockId;
	}
	public String getDisposalMethod() {
		return disposalMethod;
	}
	public void setDisposalMethod(String disposalMethod) {
		this.disposalMethod = disposalMethod;
	}
	public String getDisposalStation() {
		return disposalStation;
	}
	public void setDisposalStation(String disposalStation) {
		this.disposalStation = disposalStation;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	 
	
}
