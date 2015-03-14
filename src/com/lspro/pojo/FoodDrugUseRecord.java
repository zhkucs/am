package com.lspro.pojo;

/**
 * Description:
 * 饲料、饲料添加剂和兽药使用记录。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
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
@Table(name="饲料或饲料添加剂或兽药用记录")
public class FoodDrugUseRecord {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="开始使用时间")
	private String startTime;    //开始使用时间
	@Column(name="投入产品名称")
	private String productName;	//投入产品
	@Column(name="生产厂家")
	private String manufacturer;	//生产厂商
	@Column(name="批号或加工日期")
	private String BatchNum;	//批号/加工日期
	@Column(name="用量")
	private Double dosage;	//用量
	@Column(name="停止使用时间")
	private String stopTime;	//停止时间
	@Column(name="备注")
	private String note;	//备注(1、养殖场外购的饲料应在备注栏注明原料组成。
							//	  2、养殖场自加工的饲料在生产厂家栏填写自加工，并在备注栏写明使用的药物饲料添加剂的详细成分)
	
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
