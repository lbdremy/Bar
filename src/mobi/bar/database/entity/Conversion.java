package mobi.bar.database.entity;

public class Conversion {
	
	public final static int KIND_UNIT_WEIGHT = 1;
	public final static int KIND_UNIT_VOLUME = 2;
	public final static int KIND_UNIT_SIZE = 3;
	public final static int KIND_UNIT_TEMPERATURE = 4;
	
	private int id;
	private double valueBefore;
	private String unitBefore;
	private double valueAfter;
	private String unitAfter;
	private int kindUnit;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setKindUnit(int kindUnit) {
		this.kindUnit = kindUnit;
	}
	public int getKindUnit() {
		return kindUnit;
	}
}
