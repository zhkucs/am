package com.lspro.pojo;

/**
 * Description:
 * ������ߺϸ�֤����(��ƷA)��<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
 * @version 1.0
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="������ߺϸ�֤����_��ƷA")
public class ProductA {
	@Id @Column(name="���")
	private String id;
	@Column(name="������")
	private String shipperName;
	@Column(name="��ϵ�绰")
	private String phoneNum;
	@Column(name="��Ʒ����")
	private String productName;
	@Column(name="�����Լ���λ")
	private String number;
	@Column(name="������ַ������")
	private String addressName;
	@Column(name="Ŀ�ĵ�")
	private String destination;
	@Column(name="������")
	private String carrier;
	@Column(name="��������ϵ�绰")
	private String carrierPhone;
	@Column(name="���ط�ʽ")
	private String transportWay;
	@Column(name="���ع����ƺ�")
	private String transportId;
	@Column(name="���ع����������")
	private boolean isDisinfection;
	@Column(name="��ע")
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
