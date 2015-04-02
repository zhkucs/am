package com.lspro.pojo;

/**
 * Description:
 * 动物检疫合格证明表(动物A)。<br/>
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
@Table(name="动物检疫合格证明表_动物A")
public class AnimalA {
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
	@Column(name="启运地点")
	private String startAddress;
	@Column(name="到达地点")
	private String destination;
	@Column(name="用途")
	private String use;
	@Column(name="承运人")
	private String carrier;
	@Column(name="承运人联系电话")
	private String carrierPhone;
	@Column(name="运载方式")
	private String transportWay;
	@Column(name="运载工具牌号")
	private String transportId;
	@Column(name="运载工具消毒情况")
	private boolean isDisinfection;
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="牲畜耳标表_A" ,joinColumns=@JoinColumn(name="编号",nullable=false))
	@Column(name="牲畜耳标号")
	@OrderColumn(name="索引")
	private List<String> animalId;
	@Column(name="备注")
	private String note;
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
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getCarrierPhone() {
		return carrierPhone;
	}
	public void setCarrierPhone(String carrierPhone) {
		this.carrierPhone = carrierPhone;
	}
	public String getTransportWay() {
		return transportWay;
	}
	public void setTransportWay(String transportWay) {
		this.transportWay = transportWay;
	}
	public String getTransportId() {
		return transportId;
	}
	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}
	public boolean isDisinfection() {
		return isDisinfection;
	}
	public void setDisinfection(boolean isDisinfection) {
		this.isDisinfection = isDisinfection;
	}
	public List<String> getAnimalId() {
		return animalId;
	}
	public void setAnimalId(List<String> animalId) {
		this.animalId = animalId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	


}
