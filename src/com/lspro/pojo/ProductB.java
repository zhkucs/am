package com.lspro.pojo;

/**
 * Description:
 * ������ߺϸ�֤����(��ƷB)��<br/>
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
@Table(name="������ߺϸ�֤����_��ƷB")
public class ProductB {
	@Id @Column(name="���")
	private String id;
	@Column(name="������")
	private String shipperName;
	@Column(name="��Ʒ����")
	private String productName;
	@Column(name="�����Լ���λ")
	private String number;
	@Column(name="����")
	private String producter;
	@Column(name="������ַ������")
	private String addressName;
	@Column(name="Ŀ�ĵ�")
	private String destination;
	@Column(name="���߱�־��")
	private String Quarantinemarks;
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
