package mobi.bar.dao;

import android.content.Context;

public class DaoFactory {
	private static ConversionDao conversionDao;
	
	public static ConversionDao getConversionDao(Context context){
		if(conversionDao == null)
			conversionDao = new ConversionDaoImpl(context);
		return conversionDao;
	}
}
