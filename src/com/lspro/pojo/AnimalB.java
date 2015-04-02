package com.lspro.pojo;

/**
 * Description:
 * 动物检疫合格证明表(动物B)。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
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
@Table(name="动物检疫合格证明表_动物B")
public class AnimalB {
	@Id @Column(name="编号")
	private String id;
	@Column(name="货主名")
	private String shipperName;
	@Column(name="联系电话")
	private String phoneNum;
	@Column(name="动物种类")
	private String animalSpecies;
	@Column(name="数量以及单位")
	private String number;
	@Column(name="用途")
	private String use;
	@Column(name="启运地点")
	private String startAddress;
	@Column(name="到达地点")
	private String destination;
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="牲畜耳标表_B" ,joinColumns=@JoinColumn(name="编号",nullable=false))
	@Column(name="牲畜耳标号")
	@OrderColumn(name="索引")
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
