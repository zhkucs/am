package com.lspro.pojo;

/**
 * Description:
 * 消毒记录数据表基本信息。<br/>
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
@Table(name = "消毒记录表")
public class DisinfectionRecord {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  //标识id
	
	@Column(name="消毒时间")
	private String disinfectionTime;	//消毒时间
	@Column(name="消毒场所")
	private String place;		//消毒场所
	@Column(name="消毒药名称")
	private String disinfectionName;	//消毒药名称
	@Column(name="消毒药剂量")
	private Double disinfectioDose;		//消毒药剂量
	@Column(name="消毒方法")
	private String method;  //消毒方法
	@Column(name="负责人")
	private String sign;	//负责人签字
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDisinfectionTime() {
		return disinfectionTime;
	}
	public void setDisinfectionTime(String disinfectionTime) {
		this.disinfectionTime = disinfectionTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDisinfectionName() {
		return disinfectionName;
	}
	public void setDisinfectionName(String disinfectionName) {
		this.disinfectionName = disinfectionName;
	}
	public Double getDisinfectioDose() {
		return disinfectioDose;
	}
	public void setDisinfectioDose(Double disinfectioDose) {
		this.disinfectioDose = disinfectioDose;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((disinfectioDose == null) ? 0 : disinfectioDose.hashCode());
		result = prime
				* result
				+ ((disinfectionName == null) ? 0 : disinfectionName.hashCode());
		result = prime
				* result
				+ ((disinfectionTime == null) ? 0 : disinfectionTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((sign == null) ? 0 : sign.hashCode());
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
		DisinfectionRecord other = (DisinfectionRecord) obj;
		if (disinfectioDose == null) {
			if (other.disinfectioDose != null)
				return false;
		} else if (!disinfectioDose.equals(other.disinfectioDose))
			return false;
		if (disinfectionName == null) {
			if (other.disinfectionName != null)
				return false;
		} else if (!disinfectionName.equals(other.disinfectionName))
			return false;
		if (disinfectionTime == null) {
			if (other.disinfectionTime != null)
				return false;
		} else if (!disinfectionTime.equals(other.disinfectionTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (sign == null) {
			if (other.sign != null)
				return false;
		} else if (!sign.equals(other.sign))
			return false;
		return true;
	}
	
 
}
