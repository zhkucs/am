package com.lspro.pojo;
/**
 * Description:
 * ���ʴ���������Ϣ.
 * @author л����
 * @version 1.0
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="���ʴ��������")
public class Supplies {
	@Id @Column(name="���ʱ��")
	private String suppliesId;	//���ʱ��
	@Column(name="��������")
	private String suppliesName;	//��������
	@Column(name="���ʼ۸�")
	private Double suppliesPrice;	//���ʼ۸�
	@Column(name="����������")
	private String producter;		//����������
	@Column(name="��������")
	private Integer number;		//��������
	@Column(name="��Ч��")
	private String validDate;	//��Ч��
	@Column(name="������")
	private String reservePlace;	//������
	@Column(name="ʧЧ���")
	private String failSitution;	//ʧЧ���
	@Column(name="����λ")
	private String managementstation;	//����λ
	@Column(name="������")
	private String head;	//������
	 
	public String getSuppliesId() {
		
		return suppliesId;
	}
	public void setSuppliesId(String suppliesId) {
		this.suppliesId = suppliesId;
	}
	public String getSuppliesName() {
		return suppliesName;
	}
	public void setSuppliesName(String suppliesName) {
		this.suppliesName = suppliesName;
	}
	public Double getSuppliesPrice() {
		return suppliesPrice;
	}
	public void setSuppliesPrice(Double suppliesPrice) {
		this.suppliesPrice = suppliesPrice;
	}
	public String getProducter() {
		return producter;
	}
	public void setProducter(String producter) {
		this.producter = producter;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getReservePlace() {
		return reservePlace;
	}
	public void setReservePlace(String reservePlace) {
		this.reservePlace = reservePlace;
	}
	public String getFailSitution() {
		return failSitution;
	}
	public void setFailSitution(String failSitution) {
		this.failSitution = failSitution;
	}
	public String getManagementstation() {
		return managementstation;
	}
	public void setManagementstation(String managementstation) {
		this.managementstation = managementstation;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
	
}
