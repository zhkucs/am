package com.lspro.pojo;

import javax.persistence.Embeddable;

/**
 * Desperation:
 * 技术人员基本信息,包括工作id,专业方向等<br>
 * 设置了所有属性相应的geter和setter方法。<br/>
 * 重写了equals和hashCode方法。<br/>
 * 使用了hibernate4.1框架，为属性进行了hibernate注解。<br/>
 * @author 阿呆
 * @see FarmMes
 * @version 1.0
 */
@Embeddable
public class TechnicalPerson {
	
	
	private String workId;			//工作id
	private String professSkill;    //专业方向
	private String farrierNum;		//技术资格证编号
	private String phoneNum;		//联系方式
	
	
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getProfessSkill() {
		return professSkill;
	}
	public void setProfessSkill(String professSkill) {
		this.professSkill = professSkill;
	}
	public String getFarrierNum() {
		return farrierNum;
	}
	public void setFarrierNum(String farrierNum) {
		this.farrierNum = farrierNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((farrierNum == null) ? 0 : farrierNum.hashCode());
		result = prime * result
				+ ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result
				+ ((professSkill == null) ? 0 : professSkill.hashCode());
		result = prime * result + ((workId == null) ? 0 : workId.hashCode());
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
		TechnicalPerson other = (TechnicalPerson) obj;
		if (farrierNum == null) {
			if (other.farrierNum != null)
				return false;
		} else if (!farrierNum.equals(other.farrierNum))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (professSkill == null) {
			if (other.professSkill != null)
				return false;
		} else if (!professSkill.equals(other.professSkill))
			return false;
		if (workId == null) {
			if (other.workId != null)
				return false;
		} else if (!workId.equals(other.workId))
			return false;
		return true;
	}
}
