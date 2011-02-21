package mobi.bar.dao;

import android.content.Context;

public class DaoFactory {
	static ConversionDao conversionDao;
	
	public static ConversionDao getConversionDao(Context context){
		if(conversionDao != null)
			new ConversionDaoImpl(context);
		return conversionDao;
	}
}
