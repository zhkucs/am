package com.lspro.pojo;

/**
 * Description:
 * ������¼���ݱ������Ϣ��<br/>
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
@Table(name = "������¼��")
public class DisinfectionRecord {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;  //��ʶid
	
	@Column(name="����ʱ��")
	private String disinfectionTime;	//����ʱ��
	@Column(name="��������")
	private String place;		//��������
	@Column(name="����ҩ����")
	private String disinfectionName;	//����ҩ����
	@Column(name="����ҩ����")
	private Double disinfectioDose;		//����ҩ����
	@Column(name="��������")
	private String method;  //��������
	@Column(name="������")
	private String sign;	//������ǩ��
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
