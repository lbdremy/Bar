package mobi.bar.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import mobi.bar.database.DBAdapter;
import mobi.bar.database.entity.Conversion;

public class ConversionDaoImpl implements ConversionDao {
	/*Table name */
	private static final String TABLE_NAME = "conversion";
	/*Columns name */
	private static final String KEY_ID = "id";
	private static final String KEY_UNIT_BEFORE ="unit_before";
	private static final String KEY_UNIT_AFTER ="unit_after";
	private static final String KEY_VALUE_BEFORE="value_before";
	private static final String KEY_VALUE_AFTER ="value_after";
	private static final String KEY_KIND_UNIT = "kind_unit";
	
	private static final int ID_COLUMN = 0;
	private static final int UNIT_BEFORE_COLUMN = 1;
	private static final int VALUE_BEFORE_COLUMN=2;
	private static final int UNIT_AFTER_COLUMN =3;
	private static final int VALUE_AFTER_COLUMN =4;
	private static final int VALUE_KIND_UNIT_COLUMN = 5;
	
	private DBAdapter dbAdapter;

	public ConversionDaoImpl(Context context) {
		dbAdapter = new DBAdapter(context);
	}

	@Override
	public void addConversion(Conversion conversion) {
		SQLiteDatabase db = dbAdapter.openWritable();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_UNIT_AFTER, conversion.getUnitAfter());
		contentValues.put(KEY_UNIT_BEFORE,conversion.getUnitBefore());
		Log.d("DEBUG", "Add: "+conversion.getValueAfter());
		contentValues.put(KEY_VALUE_AFTER, conversion.getValueAfter());
		contentValues.put(KEY_VALUE_BEFORE, conversion.getValueBefore());
		contentValues.put(KEY_KIND_UNIT, conversion.getKindUnit());
		
		 db.insert(TABLE_NAME, null, contentValues);
		 db.close();
	}

	@Override
	public void removeConversion(Conversion conversion) {
		SQLiteDatabase db = dbAdapter.openWritable();
		String where = KEY_ID+"="+conversion.getId();
		db.delete(TABLE_NAME, where, null);
		
		db.close();
	}

	@Override
	public void updateConversion(Conversion conversion) {
		SQLiteDatabase db = dbAdapter.openWritable();
		
		ContentValues contentValues = new ContentValues();
		contentValues.put(KEY_UNIT_AFTER, conversion.getUnitAfter());
		contentValues.put(KEY_UNIT_BEFORE,conversion.getUnitBefore());
		contentValues.put(KEY_VALUE_AFTER, conversion.getValueAfter());
		contentValues.put(KEY_VALUE_BEFORE, conversion.getValueBefore());
		contentValues.put(KEY_KIND_UNIT, conversion.getKindUnit());
		
		String where = KEY_ID+"="+conversion.getId();
		 db.update(TABLE_NAME,  contentValues,where,null);
		 
		 db.close();
	}

	@Override
	public Conversion findConversionById(int id) {
		SQLiteDatabase db = dbAdapter.openReadable();
		
		String where = KEY_ID+"="+id;
		
		Cursor cursor = db.query(TABLE_NAME, null, where, null, null, null, null);
		Conversion conversion = null;
		if(cursor.moveToFirst()){
			do{
				conversion = new Conversion();
				conversion.setId(id);
				conversion.setUnitBefore(cursor.getString(UNIT_BEFORE_COLUMN));
				conversion.setValueBefore(cursor.getDouble(VALUE_BEFORE_COLUMN));
				conversion.setUnitAfter(cursor.getString(UNIT_AFTER_COLUMN));
				conversion.setValueAfter(cursor.getDouble(VALUE_AFTER_COLUMN));
				conversion.setKindUnit(cursor.getString(VALUE_KIND_UNIT_COLUMN));
			}while(cursor.moveToNext());
		}
		db.close();
		return conversion;
	}

	@Override
	public List<Conversion> findAllConversion() {
		SQLiteDatabase db = dbAdapter.openReadable();
		
		Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
		List<Conversion> conversions = new ArrayList<Conversion>();
		if(cursor.moveToFirst()){
			do{
				Conversion  conversion = new Conversion();
				conversion.setId(cursor.getInt(ID_COLUMN));
				conversion.setUnitBefore(cursor.getString(UNIT_BEFORE_COLUMN));
				conversion.setValueBefore(cursor.getDouble(VALUE_BEFORE_COLUMN));
				conversion.setUnitAfter(cursor.getString(UNIT_AFTER_COLUMN));
				conversion.setValueAfter(cursor.getDouble(VALUE_AFTER_COLUMN));
				conversion.setKindUnit(cursor.getString(VALUE_KIND_UNIT_COLUMN));
				Log.d("DEBUG","List all :"+cursor.getString(VALUE_AFTER_COLUMN));
				conversions.add(conversion);
			}while(cursor.moveToNext());
		}
		db.close();
		return conversions;
	}

	@Override
	public boolean isAlreadyExits(Conversion conversion) {
		SQLiteDatabase db = dbAdapter.openReadable();
		
		String where = KEY_VALUE_BEFORE+"="+conversion.getValueBefore()+" AND "+KEY_UNIT_BEFORE+"='"+conversion.getUnitBefore() + "' AND "+ KEY_VALUE_AFTER+"="+conversion.getValueAfter()+" AND "+KEY_UNIT_AFTER+"='"+conversion.getUnitAfter()+"'";
		Cursor cursor = db.query(TABLE_NAME, null, where, null, null, null, null);
		if(cursor.moveToFirst()){
			return true;
		}
		db.close();
		return false;
	}

}
