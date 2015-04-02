package com.lspro.pojo;

/**
 * Description:
 * 动物检疫合格证明表(产品A)。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
 * @version 1.0
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="动物检疫合格证明表_产品A")
public class ProductA {
	@Id @Column(name="编号")
	private String id;
	@Column(name="货主名")
	private String shipperName;
	@Column(name="联系电话")
	private String phoneNum;
	@Column(name="产品名称")
	private String productName;
	@Column(name="数量以及单位")
	private String number;
	@Column(name="生产地址及名字")
	private String addressName;
	@Column(name="目的地")
	private String destination;
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
