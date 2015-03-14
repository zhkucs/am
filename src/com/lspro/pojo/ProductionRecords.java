package com.lspro.pojo;

/**
 * Description:
 * 生产记录的基本信息.
 * @author 谢福成
 * @version 1.0
 *
 */
 
import javax.persistence.*;


@Entity
@Table(name="生产记录表")
public class ProductionRecords{
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="圈舍号")
	private String roomNum;  //圈舍号(畜禽饲养的圈，舍，栏的编号或名称)
	@Column(name="时间")
	private String recordDate;  //时间(出生,调入,调出和死淘的时间)
	@Column(name="出生数目")
	private Integer birthNum;	//出生数目
	@Column(name="调入数目")
	private Integer putNum;		//调入数目,调入的需要在备注栏注明动物检疫合格证明编号
	@Column(name="调出数目")
	private Integer inNum;		//调出数目,调出的需要在备注栏注明详细的去向
	@Column(name="死淘数目")
	private Integer deadNum;	//死淘数目,死亡的需要在备注栏注明死亡和淘汰的原因。
	@Column(name="存栏数")
	private Integer remainNum;	//上次存栏和变动的数量之和
	@Column(name="备注")
	private String note;	//备注
	
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public Integer getBirthNum() {
		return birthNum;
	}
	public void setBirthNum(Integer birthNum) {
		this.birthNum = birthNum;
	}
	public Integer getPutNum() {
		return putNum;
	}
	public void setPutNum(Integer putNum) {
		this.putNum = putNum;
	}
	public Integer getInNum() {
		return inNum;
	}
	public void setInNum(Integer inNum) {
		this.inNum = inNum;
	}
	public Integer getDeadNum() {
		return deadNum;
	}
	public void setDeadNum(Integer deadNum) {
		this.deadNum = deadNum;
	}
	public Integer getRemainNum() {
		return remainNum;
	}
	public void setRemainNum(Integer remainNum) {
		this.remainNum = remainNum;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthNum == null) ? 0 : birthNum.hashCode());
		result = prime * result + ((deadNum == null) ? 0 : deadNum.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inNum == null) ? 0 : inNum.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((putNum == null) ? 0 : putNum.hashCode());
		result = prime * result
				+ ((recordDate == null) ? 0 : recordDate.hashCode());
		result = prime * result
				+ ((remainNum == null) ? 0 : remainNum.hashCode());
		result = prime * result + ((roomNum == null) ? 0 : roomNum.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductionRecords other = (ProductionRecords) obj;
		if (birthNum == null) {
			if (other.birthNum != null)
				return false;
		} else if (!birthNum.equals(other.birthNum))
			return false;
		if (deadNum == null) {
			if (other.deadNum != null)
				return false;
		} else if (!deadNum.equals(other.deadNum))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inNum == null) {
			if (other.inNum != null)
				return false;
		} else if (!inNum.equals(other.inNum))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (putNum == null) {
			if (other.putNum != null)
				return false;
		} else if (!putNum.equals(other.putNum))
			return false;
		if (recordDate == null) {
			if (other.recordDate != null)
				return false;
		} else if (!recordDate.equals(other.recordDate))
			return false;
		if (remainNum == null) {
			if (other.remainNum != null)
				return false;
		} else if (!remainNum.equals(other.remainNum))
			return false;
		if (roomNum == null) {
			if (other.roomNum != null)
				return false;
		} else if (!roomNum.equals(other.roomNum))
			return false;
		return true;
	}
	
	
}
