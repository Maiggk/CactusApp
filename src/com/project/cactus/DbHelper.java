/**
 * 
 */
package com.project.cactus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Miguel
 *
 */

public class DbHelper extends SQLiteOpenHelper {
	
	private static final String DB_NAME = "cactus.sqlite";//Nombre del archivo de la BD
	private static final int DB_SCHEME_VERSION = 1;//Version del esquema de la base de datos(no version de SQLite)
	
	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_SCHEME_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DatabaseManager.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
