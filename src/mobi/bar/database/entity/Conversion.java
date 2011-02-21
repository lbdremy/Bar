package mobi.bar.database.entity;

public class Conversion {
	
	private int id;
	private double valueBefore;
	private String unitBefore;
	private double valueAfter;
	private String unitAfter;
	
	public void setValueBefore(double valueBefore) {
		this.valueBefore = valueBefore;
	}
	public double getValueBefore() {
		return valueBefore;
	}
	public void setUnitBefore(String unitBefore) {
		this.unitBefore = unitBefore;
	}
	public String getUnitBefore() {
		return unitBefore;
	}
	public void setValueAfter(double valueAfter) {
		this.valueAfter = valueAfter;
	}
	public double getValueAfter() {
		return valueAfter;
	}
	public void setUnitAfter(String unitAfter) {
		this.unitAfter = unitAfter;
	}
	public String getUnitAfter() {
		return unitAfter;
	}
	
	public String getId() {
		return null;
	}
	public void setId(int id) {
		this.id = id;
	}
}
