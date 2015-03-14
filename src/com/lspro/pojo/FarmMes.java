package com.lspro.pojo;

/**
 * Description:
 * ��ֳ������������Ϣ�������ƣ�Ʒ�֣���ģ����ַ�ȡ�<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
 * @see TechnicalPerson
 * @version 2.0(�ڰ汾1.0�Ļ����޸������ݱ���Ӧ�ֶ�,��Ӣ�ı������)
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
@Table(name ="������ֳ��Ϣ��")
public class FarmMes {
	@Id @Column(name="���ݱ�ʶ����" )
	private String farmId;    //���ݱ�ʶ����
	@Column(name="��ֳ������")
	private String farmName;  //����
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "����������Ϣ��", joinColumns=@JoinColumn(name = "���ݱ�ʶ����" , nullable = false))
	@Column(name = "����������")
	@OrderColumn(name = "����")
	private List<String> species = new ArrayList<String>();  //��ֳƷ��
	private Integer farmSize;  //��ģ
	private String location;  //��ַ
	private String leader;    //����������
	private String zipcode;   //�ʱ�
	private String phoneNum;	//��ϵ����
	//private ��������������������ʩ����Ҫ��������
	
	@ElementCollection(targetClass=TechnicalPerson.class)
	@CollectionTable(name = "������Ա��Ϣ��", joinColumns=@JoinColumn(name = "���ݱ�ʶ����" , nullable = false))
	@Column(name = "������Ա����")
	@OrderColumn(name = "����")
	private List<TechnicalPerson> person = new ArrayList<TechnicalPerson>(); //������Ա��Ϣ
	@Column(name="��������ʸ�֤���")
	private String certificate ;  //��������ʸ�֤���
	
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name = "������ʩ��", joinColumns=@JoinColumn(name = "���ݱ�ʶ����" , nullable = false))
	@Column(name = "��ʩ��")
	@OrderColumn(name = "����")
	private List<String> envirEquip = new ArrayList<String>();  //  ������ʩ
	@Column(name="�Ƿ����")
	private boolean isAccept ; //�Ƿ����
	@Column(name="ƽ��ͼ��Ϣ")
	private String farmPhoto;  //ƽ��ͼ
	@Column(name="���߳���")
	private String ImmunePro;  //���߳���
	
	/*
	 * ����Ϊ���Ե�get��set������
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
	 * ������д��hashCode��equals�������Ա����ڶ�������жϡ�
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
