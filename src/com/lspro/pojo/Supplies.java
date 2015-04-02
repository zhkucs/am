package com.lspro.pojo;
/**
 * Description:
 * 物资储备基本信息.
 * @author 谢福成
 * @version 1.0
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="物资储备管理表")
public class Supplies {
	@Id @Column(name="物资编号")
	private String suppliesId;	//物资编号
	@Column(name="物资名称")
	private String suppliesName;	//物资名称
	@Column(name="物资价格")
	private Double suppliesPrice;	//物资价格
	@Column(name="物资生产商")
	private String producter;		//物资生产商
	@Column(name="物资数量")
	private Integer number;		//物资数量
	@Column(name="有效期")
	private String validDate;	//有效期
	@Column(name="储备点")
	private String reservePlace;	//储备点
	@Column(name="失效情况")
	private String failSitution;	//失效情况
	@Column(name="管理单位")
	private String managementstation;	//管理单位
	@Column(name="负责人")
	private String head;	//负责人
	 
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
