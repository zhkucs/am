package com.lspro.pojo;

/**
 * Description:
 * 免疫记录数据表。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
 * @see Vaccine
 * @version 1.0
 * 
 */

import java.util.ArrayList;
 
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="免疫记录表")
public class ImmuneRecord {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="时间")
	private String immuneTime;
	@Column(name="圈舍号")
	private String roomNum;
	@Column(name="存栏数量")
 	private Integer remainNum;
	
	@ElementCollection(targetClass=Vaccine.class)
	@CollectionTable(name = "疫苗信息表", joinColumns=@JoinColumn(name = "id" , nullable = false))
	@Column(name="免疫")
 	@OrderColumn(name = "索引")
	private List<Vaccine> vaccineMes = new ArrayList<Vaccine>();
	
	@Column(name="备注")
	private String note;
	
	public String getImmuneTime() {
		return immuneTime;
	}
	public void setImmuneTime(String immuneTime) {
		this.immuneTime = immuneTime;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getRemainNum() {
		return remainNum;
	}
	public void setRemainNum(Integer remainNum) {
		this.remainNum = remainNum;
	}

	public List<Vaccine> getVaccineMes() {
		return vaccineMes;
	}
	public void setVaccineMes(List<Vaccine> vaccineMes) {
		this.vaccineMes = vaccineMes;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
 

}
