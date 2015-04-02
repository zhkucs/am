package com.lspro.pojo;

/**
 * Description:
 * 动物检疫合格证明表(产品B)。<br/>
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
@Table(name="动物检疫合格证明表_产品B")
public class ProductB {
	@Id @Column(name="编号")
	private String id;
	@Column(name="货主名")
	private String shipperName;
	@Column(name="产品名称")
	private String productName;
	@Column(name="数量以及单位")
	private String number;
	@Column(name="产地")
	private String producter;
	@Column(name="生产地址及名字")
	private String addressName;
	@Column(name="目的地")
	private String destination;
	@Column(name="检疫标志号")
	private String Quarantinemarks;
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
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getQuarantinemarks() {
		return Quarantinemarks;
	}
	public void setQuarantinemarks(String quarantinemarks) {
		Quarantinemarks = quarantinemarks;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getProducter() {
		return producter;
	}
	public void setProducter(String producter) {
		this.producter = producter;
	}

	
	
}
