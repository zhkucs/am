package com.lspro.pojo;

import javax.persistence.Embeddable;

/**
 * Desperation:
 * ������Ա������Ϣ,��������id,רҵ�����<br>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author ����
 * @see FarmMes
 * @version 1.0
 */
@Embeddable
public class TechnicalPerson {
	
	
	private String workId;			//����id
	private String professSkill;    //רҵ����
	private String farrierNum;		//�����ʸ�֤���
	private String phoneNum;		//��ϵ��ʽ
	
	
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
