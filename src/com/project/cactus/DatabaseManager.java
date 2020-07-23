/**
 * 
 */
package com.project.cactus;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Migue
 *
 */
public class DatabaseManager {
	public static final String TABLE_NAME = "cactaceas";//Nombre de la tabla
	
	public static final String CN_ID = "_id";//Nombre de los campos(columnas)
	public static final String CN_NAME = "nombre_comun";
	public static final String CN_NAME_SCIENTIFIC = "nombre_cientifico";
	public static final String CN_IDENTIFICADOR="identificador_universal";
	public static final String CN_FECHA_COLECTA="fecha_recoleccion";
	public static final String CN_MUNICIPIO="municipio";
	public static final String CN_LATITUD="latitud";
	public static final String CN_LONGITUD="longitud";
	public static final String CN_INFORMACION="informacion";
	public static final String CN_FOTO="imagen";
	public static final String CN_PELIGRO="peligro_extincion";
	
	
	/*create table cactus(_id integer primary key autoincrement,
						  nombre text not null,
						  nombre_cientifico text not null,
						  identificador_universal text
						  fecha_recoleccion text(date),
						  municipio text,
						  latitud text,
						  longitud integer,
						  informacion text,
						  imagen blob ó text);*/
	public static final String CREATE_TABLE = "create table "+TABLE_NAME+"("
			+CN_ID+" integer primary key autoincrement,"
			+CN_NAME+" text not null,"
			+CN_NAME_SCIENTIFIC+" text not null,"
			+CN_IDENTIFICADOR+" text,"
			+CN_PELIGRO+" text,"
			+CN_FECHA_COLECTA+" text,"
			+CN_MUNICIPIO+" text,"
			+CN_LATITUD+" integer,"
			+CN_LONGITUD+" integer,"
			+CN_INFORMACION+" text,"
			+CN_FOTO+" text);";
	
	private DbHelper helper;
	private SQLiteDatabase db;
	
	public DatabaseManager(Context context){
		helper = new DbHelper(context);//Recive como parametro el contexto de la aplicacion
        db=helper.getWritableDatabase();//Obtencion de la base de datos en modo escritura
        //NO OLVIDES PONER LA BASE DE DATOS EN READ-ONLY AL FINAL DEL PROYECTO
	}
	
	private ContentValues generarContentValues(String nombre_comun,String nombre_cientifico,String identificador_universal
			,String peligro_extincion,String fecha_colecta,String municipio,int latitud,int longitud,String informacion,
			String direccion_foto){
		ContentValues valores=new ContentValues();
		valores.put(CN_NAME,nombre_comun);
		valores.put(CN_NAME_SCIENTIFIC, nombre_cientifico);
		valores.put(CN_IDENTIFICADOR,identificador_universal);
		valores.put(CN_PELIGRO, peligro_extincion);
		valores.put(CN_FECHA_COLECTA, fecha_colecta);
		valores.put(CN_MUNICIPIO, municipio);
		valores.put(CN_LATITUD,latitud);
		valores.put(CN_LONGITUD, longitud);
		valores.put(CN_INFORMACION, informacion);
		valores.put(CN_FOTO, direccion_foto);
		
		return valores;
	}
	
	public void insertar_registro(String nombre_comun,String nombre_cientifico,String identificador_universal
			,String peligro_extincion,String fecha_colecta,String municipio,int latitud,int longitud,String informacion,
			String direccion_foto){
		
		db.insert(TABLE_NAME, null, generarContentValues(nombre_comun,nombre_cientifico,identificador_universal
				,peligro_extincion,fecha_colecta,municipio,latitud,longitud,informacion,direccion_foto));
	}
	
	public Cursor cargarCursorCactaceas(){
		//query(String tabla,String[] columnas,String select,String[] argumentos_select,String groupBy,String having,String order by);
		String[] columnas=new String[]{CN_ID,CN_NAME,CN_NAME_SCIENTIFIC,CN_IDENTIFICADOR,CN_PELIGRO,CN_FECHA_COLECTA,CN_MUNICIPIO,CN_LATITUD,CN_LONGITUD,CN_INFORMACION,CN_FOTO};
		return db.query(TABLE_NAME, columnas, null, null, null, null, null);
	}
	
	public Cursor query(String id){	
		String[] columnas=new String[]{CN_ID,CN_NAME,CN_NAME_SCIENTIFIC,CN_IDENTIFICADOR,CN_PELIGRO,CN_FECHA_COLECTA,CN_MUNICIPIO,CN_LATITUD,CN_LONGITUD,CN_INFORMACION,CN_FOTO};
		return db.query(TABLE_NAME, columnas,CN_ID+"=?",new String[]{id},null,null,null);
	}
	
	public Cursor query_name(String name){	
		String[] columnas=new String[]{CN_ID,CN_NAME,CN_NAME_SCIENTIFIC,CN_IDENTIFICADOR,CN_PELIGRO,CN_FECHA_COLECTA,CN_MUNICIPIO,CN_LATITUD,CN_LONGITUD,CN_INFORMACION,CN_FOTO};
		return db.query(TABLE_NAME, columnas,CN_NAME+"=?",new String[]{name},null,null,null);
	}
}
