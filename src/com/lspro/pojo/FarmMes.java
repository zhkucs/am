package com.lspro.pojo;

/**
 * Description:
 * 养殖场档案基本信息，如名称，品种，规模，地址等。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
 * @see TechnicalPerson
 * @version 2.0(在版本1.0的基础修改了数据表相应字段,由英文变成中文)
 * 
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table(name ="畜禽养殖信息表")
public class FarmMes {
	@Id @Column(name="畜禽标识代码" )
	private String farmId;    //畜禽标识代码
	@Column(name="养殖场名称")
	private String farmName;  //名称
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "畜禽种类信息表", joinColumns=@JoinColumn(name = "畜禽标识代码" , nullable = false))
	@Column(name = "畜禽种类名")
	@OrderColumn(name = "索引")
	private List<String> species = new ArrayList<String>();  //养殖品种
	private Integer farmSize;  //规模
	private String location;  //地址
	private String leader;    //负责人姓名
	private String zipcode;   //邮编
	private String phoneNum;	//联系号码
	//private 生产场所和配套生产设施（主要生产工艺
	
	@ElementCollection(targetClass=TechnicalPerson.class)
	@CollectionTable(name = "技术人员信息表", joinColumns=@JoinColumn(name = "畜禽标识代码" , nullable = false))
	@Column(name = "技术人员姓名")
	@OrderColumn(name = "索引")
	private List<TechnicalPerson> person = new ArrayList<TechnicalPerson>(); //技术人员信息
	@Column(name="动物防疫资格证编号")
	private String certificate ;  //动物防疫资格证编号
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "环保设施表", joinColumns=@JoinColumn(name = "畜禽标识代码" , nullable = false))
	@Column(name = "设施名")
	@OrderColumn(name = "索引")
	private List<String> envirEquip = new ArrayList<String>();  //  环保设施
	@Column(name="是否接收")
	private boolean isAccept ; //是否接收
	@Column(name="平面图信息")
	private String farmPhoto;  //平面图
	@Column(name="免疫程序")
	private String ImmunePro;  //免疫程序
	
	/*
	 * 以下为属性的get和set方法。
	 */
	public String getFarmId() {
		return farmId;
	}
	public void setFarmId(String farmId) {
		this.farmId = farmId;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public List<String> getSpecies() {
		return species;
	}
	public void setSpecies(List<String> species) {
		this.species = species;
	}
	public Integer getFarmSize() {
		return farmSize;
	}
	public void setFarmSize(Integer farmSize) {
		this.farmSize = farmSize;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public List<TechnicalPerson> getPerson() {
		return person;
	}
	public void setPerson(List<TechnicalPerson> person) {
		this.person = person;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public List<String> getEnvirEquip() {
		return envirEquip;
	}
	public void setEnvirEquip(List<String> envirEquip) {
		this.envirEquip = envirEquip;
	}
	public boolean isAccept() {
		return isAccept;
	}
	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}
	public String getFarmPhoto() {
		return farmPhoto;
	}
	public void setFarmPhoto(String farmPhoto) {
		this.farmPhoto = farmPhoto;
	}
	public String getImmunePro() {
		return ImmunePro;
	}
	public void setImmunePro(String immunePro) {
		ImmunePro = immunePro;
	}
	
	/*
	 * 以下重写了hashCode和equals方法，以便用于对象相等判断。
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ImmunePro == null) ? 0 : ImmunePro.hashCode());
		result = prime * result
				+ ((certificate == null) ? 0 : certificate.hashCode());
		result = prime * result
				+ ((envirEquip == null) ? 0 : envirEquip.hashCode());
		result = prime * result + ((farmId == null) ? 0 : farmId.hashCode());
		result = prime * result
				+ ((farmName == null) ? 0 : farmName.hashCode());
		result = prime * result
				+ ((farmPhoto == null) ? 0 : farmPhoto.hashCode());
		result = prime * result
				+ ((farmSize == null) ? 0 : farmSize.hashCode());
		result = prime * result + (isAccept ? 1231 : 1237);
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result
				+ ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		FarmMes other = (FarmMes) obj;
		if (ImmunePro == null) {
			if (other.ImmunePro != null)
				return false;
		} else if (!ImmunePro.equals(other.ImmunePro))
			return false;
		if (certificate == null) {
			if (other.certificate != null)
				return false;
		} else if (!certificate.equals(other.certificate))
			return false;
		if (envirEquip == null) {
			if (other.envirEquip != null)
				return false;
		} else if (!envirEquip.equals(other.envirEquip))
			return false;
		if (farmId == null) {
			if (other.farmId != null)
				return false;
		} else if (!farmId.equals(other.farmId))
			return false;
		if (farmName == null) {
			if (other.farmName != null)
				return false;
		} else if (!farmName.equals(other.farmName))
			return false;
		if (farmPhoto == null) {
			if (other.farmPhoto != null)
				return false;
		} else if (!farmPhoto.equals(other.farmPhoto))
			return false;
		if (farmSize == null) {
			if (other.farmSize != null)
				return false;
		} else if (!farmSize.equals(other.farmSize))
			return false;
		if (isAccept != other.isAccept)
			return false;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
