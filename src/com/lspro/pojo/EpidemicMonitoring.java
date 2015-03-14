package com.lspro.pojo;

/**
 * Description:
 * 防疫监测记录基本数据表。<br/>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 谢福成
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
@Table(name="防疫监测记录表")
public class EpidemicMonitoring {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="采样日期")
	private String samplingTime;	//采样日期
	@Column(name="圈舍号")
	private String roomNum;	//圈舍号
	@Column(name="采样数量")
	private Integer samplingNum;	//采样数量
	@Column(name="监测项目")
	private String monitoringName;	//监测项目
	@Column(name="监测单位")
	private String monitoringStation;	//监测单位
	@Column(name="监测结果")
	private String monitoringResult;	//监测结果
	@Column(name="处理情况")
	private String disposalConditions;	//处理情况
	@Column(name="备注")
	private String note;	//备注
 
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
