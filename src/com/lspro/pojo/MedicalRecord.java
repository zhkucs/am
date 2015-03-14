package com.lspro.pojo;

/**
 * Description:
 * 诊疗记录基本数据表。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
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
@Table(name="诊疗记录表")
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  //标识id
	@Column(name="诊疗日期")
	private String medicalTime; 	//诊疗日期	
	@Column(name="畜禽标识编码")
	private String LivestockId;	//畜禽标识编码
	@Column(name="圈舍号")
	private String roomNum;	//圈舍号
	@Column(name="日龄")
	private Integer dateAge;	//日龄
	@Column(name="发病数")
	private Integer sickNum;	//发病数
	@Column(name="病因")
	private String sickReason;	//病因
	@Column(name="诊疗人员")
	private String medicalPeo;	//诊疗人员
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="用药表",joinColumns=@JoinColumn(name="id" , nullable=false))
	@MapKeyColumn(name ="用药名称")
	@MapKeyClass(String.class)
	@Column(name ="用药信息")
	private Map<String, String> medicine = new TreeMap<String, String>();	//用药以及用药方法
	@Column(name="诊疗结果")
	private String medicalResult;	//诊疗结果
	
	
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
