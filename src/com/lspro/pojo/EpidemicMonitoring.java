package com.lspro.pojo;

/**
 * Description:
 * ���߼���¼�������ݱ�<br/>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author л����
 * @version 1.0
 * 
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="���߼���¼��")
public class EpidemicMonitoring {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="��������")
	private String samplingTime;	//��������
	@Column(name="Ȧ���")
	private String roomNum;	//Ȧ���
	@Column(name="��������")
	private Integer samplingNum;	//��������
	@Column(name="�����Ŀ")
	private String monitoringName;	//�����Ŀ
	@Column(name="��ⵥλ")
	private String monitoringStation;	//��ⵥλ
	@Column(name="�����")
	private String monitoringResult;	//�����
	@Column(name="�������")
	private String disposalConditions;	//�������
	@Column(name="��ע")
	private String note;	//��ע
 
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getSamplingNum() {
		return samplingNum;
	}
	public void setSamplingNum(Integer samplingNum) {
		this.samplingNum = samplingNum;
	}
	public String getMonitoringName() {
		return monitoringName;
	}
	public void setMonitoringName(String monitoringName) {
		this.monitoringName = monitoringName;
	}
	public String getMonitoringStation() {
		return monitoringStation;
	}
	public void setMonitoringStation(String monitoringStation) {
		this.monitoringStation = monitoringStation;
	}
	public String getMonitoringResult() {
		return monitoringResult;
	}
	public void setMonitoringResult(String monitoringResult) {
		this.monitoringResult = monitoringResult;
	}
	public String getDisposalConditions() {
		return disposalConditions;
	}
	public void setDisposalConditions(String disposalConditions) {
		this.disposalConditions = disposalConditions;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSamplingTime() {
		return samplingTime;
	}
	public void setSamplingTime(String samplingTime) {
		this.samplingTime = samplingTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	 
	
}
