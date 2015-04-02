package com.lspro.pojo;

/**
 * Description:
 * ������ߺϸ�֤����(����B)��<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
 * @version 1.0
 * 
 */

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
@Table(name="������ߺϸ�֤����_����B")
public class AnimalB {
	@Id @Column(name="���")
	private String id;
	@Column(name="������")
	private String shipperName;
	@Column(name="��ϵ�绰")
	private String phoneNum;
	@Column(name="��������")
	private String animalSpecies;
	@Column(name="�����Լ���λ")
	private String number;
	@Column(name="��;")
	private String use;
	@Column(name="���˵ص�")
	private String startAddress;
	@Column(name="����ص�")
	private String destination;
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="��������_B" ,joinColumns=@JoinColumn(name="���",nullable=false))
	@Column(name="��������")
	@OrderColumn(name="����")
	private List<String> animalId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAnimalSpecies() {
		return animalSpecies;
	}
	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<String> getAnimalId() {
		return animalId;
	}
	public void setAnimalId(List<String> animalId) {
		this.animalId = animalId;
	}
	
	
	
	


}
