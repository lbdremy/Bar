package mobi.bar.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBAdapter {
	
	
	private static final String DATABASE_NAME = "bar.db";
	private static final int DATABASE_VERSION = 1;
	
	private static SQLiteOpenHelper dbHelper;
	private final Context context;
	private SQLiteDatabase db;
	
	public DBAdapter(Context _context){
		context = _context;
		dbHelper= new DBHelper(context,DATABASE_NAME,null,DATABASE_VERSION);
	}
	
	public SQLiteDatabase openWritable() throws SQLException{
		db = dbHelper.getWritableDatabase();
		return db;
	}
	
	public SQLiteDatabase openReadable() throws SQLException{
		db = dbHelper.getReadableDatabase();
		return db;
	}
	
	public void close(){
		db.close();
	}
}
