package com.lspro.pojo;

/**
 * Description:
 * ���ϡ�������Ӽ�����ҩʹ�ü�¼��<br/>
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
@Table(name="���ϻ�������Ӽ�����ҩ�ü�¼")
public class FoodDrugUseRecord {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="��ʼʹ��ʱ��")
	private String startTime;    //��ʼʹ��ʱ��
	@Column(name="Ͷ���Ʒ����")
	private String productName;	//Ͷ���Ʒ
	@Column(name="��������")
	private String manufacturer;	//��������
	@Column(name="���Ż�ӹ�����")
	private String BatchNum;	//����/�ӹ�����
	@Column(name="����")
	private Double dosage;	//����
	@Column(name="ֹͣʹ��ʱ��")
	private String stopTime;	//ֹͣʱ��
	@Column(name="��ע")
	private String note;	//��ע(1����ֳ���⹺������Ӧ�ڱ�ע��ע��ԭ����ɡ�
							//	  2����ֳ���Լӹ���������������������д�Լӹ������ڱ�ע��д��ʹ�õ�ҩ��������Ӽ�����ϸ�ɷ�)
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getBatchNum() {
		return BatchNum;
	}
	public void setBatchNum(String batchNum) {
		BatchNum = batchNum;
	}
	public Double getDosage() {
		return dosage;
	}
	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((BatchNum == null) ? 0 : BatchNum.hashCode());
		result = prime * result + ((dosage == null) ? 0 : dosage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result
				+ ((stopTime == null) ? 0 : stopTime.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodDrugUseRecord other = (FoodDrugUseRecord) obj;
		if (BatchNum == null) {
			if (other.BatchNum != null)
				return false;
		} else if (!BatchNum.equals(other.BatchNum))
			return false;
		if (dosage == null) {
			if (other.dosage != null)
				return false;
		} else if (!dosage.equals(other.dosage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (stopTime == null) {
			if (other.stopTime != null)
				return false;
		} else if (!stopTime.equals(other.stopTime))
			return false;
		return true;
	}
	
	

}
