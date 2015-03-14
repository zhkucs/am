package com.lspro.pojo;

/**
 * Desperation:
 * ������Ա������Ϣ,��������id,רҵ�����<br>
 * ����������������Ӧ��geter��setter������<br/>
 * ��д��equals��hashCode������<br/>
 * ʹ����hibernate4.1��ܣ�Ϊ���Խ�����hibernateע�⡣<br/>
 * @author ����
 * @see ImmuneRecord
 * @version 1.0
 */

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Vaccine {
	
	@Column(name="��������")
	private Integer immuneNum;
	@Column(name="��������")
	private String vaccineName;
	@Column(name="�������")
	private String vaccineProducers;
	@Column(name="�������Ż���Ч��")
	private String vaccineValidTime;
	@Column(name="���߷���")
	private String immuneMethod;
	@Column(name="���߼���")
	private Double immuneDosage;
	@Column(name="������Ա")
	private String immunePeople;
	
	public Integer getImmuneNum() {
		return immuneNum;
	}
	public void setImmuneNum(Integer immuneNum) {
		this.immuneNum = immuneNum;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getVaccineProducers() {
		return vaccineProducers;
	}
	public void setVaccineProducers(String vaccineProducers) {
		this.vaccineProducers = vaccineProducers;
	}
	public String getVaccineValidTime() {
		return vaccineValidTime;
	}
	public void setVaccineValidTime(String vaccineValidTime) {
		this.vaccineValidTime = vaccineValidTime;
	}
	public String getImmuneMethod() {
		return immuneMethod;
	}
	public void setImmuneMethod(String immuneMethod) {
		this.immuneMethod = immuneMethod;
	}
	public Double getImmuneDosage() {
		return immuneDosage;
	}
	public void setImmuneDosage(Double immuneDosage) {
		this.immuneDosage = immuneDosage;
	}
	public String getImmunePeople() {
		return immunePeople;
	}
	public void setImmunePeople(String immunePeople) {
		this.immunePeople = immunePeople;
	}
	
	
}
