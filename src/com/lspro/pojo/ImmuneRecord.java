package com.lspro.pojo;

/**
 * Description:
 * ���߼�¼���ݱ�<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
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
@Table(name="���߼�¼��")
public class ImmuneRecord {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ʱ��")
	private String immuneTime;
	@Column(name="Ȧ���")
	private String roomNum;
	@Column(name="��������")
 	private Integer remainNum;
	
	@ElementCollection(targetClass=Vaccine.class)
	@CollectionTable(name = "������Ϣ��", joinColumns=@JoinColumn(name = "id" , nullable = false))
	@Column(name="����")
 	@OrderColumn(name = "����")
	private List<Vaccine> vaccineMes = new ArrayList<Vaccine>();
	
	@Column(name="��ע")
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
