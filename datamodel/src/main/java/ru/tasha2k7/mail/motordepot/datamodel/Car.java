package ru.tasha2k7.mail.motordepot.datamodel;

import java.util.Date;

import ru.tasha2k7.mail.motordepot.annotation.DBTableName;

@DBTableName(name = "car")
public class Car extends AbstractModel {

	private String makeModel;
	private String numberRegistration;
	private Double capacityCarryingKg;
	private Double lengthDimensionsM;
	private Double widthDimensionsM;
	private Double heigthDimensionsM;
	private Boolean conditionVehical;
	private Date inspectionDate;
	private Date deleted;

	private Employee employee;

	public String getMakeModel() {
		return makeModel;
	}

	public void setMakeModel(String makeModel) {
		this.makeModel = makeModel;
	}

	public String getNumberRegistration() {
		return numberRegistration;
	}

	public void setNumberRegistration(String numberRegistration) {
		this.numberRegistration = numberRegistration;
	}

	public Double getCapacityCarryingKg() {
		return capacityCarryingKg;
	}

	public void setCapacityCarryingKg(Double capacityCarryingKg) {
		this.capacityCarryingKg = capacityCarryingKg;
	}

	public Double getLengthDimensionsM() {
		return lengthDimensionsM;
	}

	public void setLengthDimensionsM(Double lengthDimensionsM) {
		this.lengthDimensionsM = lengthDimensionsM;
	}

	public Double getWidthDimensionsM() {
		return widthDimensionsM;
	}

	public void setWidthDimensionsM(Double widthDimensionsM) {
		this.widthDimensionsM = widthDimensionsM;
	}

	public Double getHeigthDimensionsM() {
		return heigthDimensionsM;
	}

	public void setHeigthDimensionsM(Double heigthDimensionsM) {
		this.heigthDimensionsM = heigthDimensionsM;
	}

	public Boolean getConditionVehical() {
		return conditionVehical;
	}

	public void setConditionVehical(Boolean conditionVehical) {
		this.conditionVehical = conditionVehical;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
