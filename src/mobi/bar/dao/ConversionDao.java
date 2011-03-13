package mobi.bar.dao;

import java.util.List;

import mobi.bar.database.entity.Conversion;

public interface ConversionDao {
	
	public void addConversion(Conversion conversion);
	public void removeConversion(Conversion conversion);
	public void updateConversion(Conversion conversion);
	public Conversion findConversionById(int id);
	public Conversion findLastEntry(int kindUnit);
	public List<Conversion> findAllConversion(String limit);
	public boolean isAlreadyExits(Conversion conversion);
	public void removeAllConversion(String limit);
}
