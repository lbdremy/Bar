package mobi.bar.database.entity;

import mobi.bar.R;
import android.graphics.drawable.Drawable;

public class Conversion {
	
	private int id;
	private double valueBefore;
	private String unitBefore;
	private double valueAfter;
	private String unitAfter;
	private String kindUnit;
	
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
	public void setKindUnit(String kindUnit) {
		this.kindUnit = kindUnit;
	}
	public String getKindUnit() {
		return kindUnit;
	}
}
