package com.lspro.pojo;

/**
 * Description:
 * ���Ƽ�¼�������ݱ�<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
 * @version 1.0
 * 
 */

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name="���Ƽ�¼��")
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  //��ʶid
	@Column(name="��������")
	private String medicalTime; 	//��������	
	@Column(name="���ݱ�ʶ����")
	private String LivestockId;	//���ݱ�ʶ����
	@Column(name="Ȧ���")
	private String roomNum;	//Ȧ���
	@Column(name="����")
	private Integer dateAge;	//����
	@Column(name="������")
	private Integer sickNum;	//������
	@Column(name="����")
	private String sickReason;	//����
	@Column(name="������Ա")
	private String medicalPeo;	//������Ա
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="��ҩ��",joinColumns=@JoinColumn(name="id" , nullable=false))
	@MapKeyColumn(name ="��ҩ����")
	@MapKeyClass(String.class)
	@Column(name ="��ҩ��Ϣ")
	private Map<String, String> medicine = new TreeMap<String, String>();	//��ҩ�Լ���ҩ����
	@Column(name="���ƽ��")
	private String medicalResult;	//���ƽ��
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMedicalTime() {
		return medicalTime;
	}
	public void setMedicalTime(String medicalTime) {
		this.medicalTime = medicalTime;
	}
	public String getLivestockId() {
		return LivestockId;
	}
	public void setLivestockId(String livestockId) {
		LivestockId = livestockId;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getDateAge() {
		return dateAge;
	}
	public void setDateAge(Integer dateAge) {
		this.dateAge = dateAge;
	}
	public Integer getSickNum() {
		return sickNum;
	}
	public void setSickNum(Integer sickNum) {
		this.sickNum = sickNum;
	}
	public String getSickReason() {
		return sickReason;
	}
	public void setSickReason(String sickReason) {
		this.sickReason = sickReason;
	}
	public String getMedicalPeo() {
		return medicalPeo;
	}
	public void setMedicalPeo(String medicalPeo) {
		this.medicalPeo = medicalPeo;
	}
	public Map<String, String> getMedicine() {
		return medicine;
	}
	public void setMedicine(Map<String, String> medicine) {
		this.medicine = medicine;
	}
	public String getMedicalResult() {
		return medicalResult;
	}
	public void setMedicalResult(String medicalResult) {
		this.medicalResult = medicalResult;
	}
	
	 
	
	 
	
	
	
	
}
