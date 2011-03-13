package mobi.bar.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
	private static final String DATABASE_NAME = "bar.db";
	
	private static final int DATABASE_VERSION = 1;
	
	private static final String CREATE_TABLE_CONVERSION =
		"CREATE TABLE IF NOT EXISTS `conversion` ("
		+"	`id` INTEGER PRIMARY KEY,"
		+"	`unit_before` varchar(40) NOT NULL,"
		+"`value_before` double NOT NULL,"
		+"	`unit_after` varchar(40) NOT NULL ,"
		+"`value_after` double NOT NULL,"
		+"	`kind_unit` int NOT NULL "
		+");";
		
	//private static final String UPDATE_TABLES ="";
	public DBHelper(Context context, String name, CursorFactory factory,int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			db.execSQL(CREATE_TABLE_CONVERSION);
			Log.d("DEBUG", "Creation des tables");
		}catch(SQLException e){
			Log.e("Exception", "SQLException during onCreate",e);
		}catch(Exception e){
			Log.e("Exception", "Exception during onCreate",e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//db.execSQL(UPDATE_TABLES);
		//onCreate(db);
	}

	public static int getDatabaseVersion() {
		return DATABASE_VERSION;
	}

	public static String getDatabaseName() {
		return DATABASE_NAME;
	}

}
