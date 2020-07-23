/**
 * 
 */
package com.project.cactus;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Migue
 *
 */
public class mostrarCactacea extends Activity{
	
	private TextView txt_nombre;
	private TextView txt_nom_cientifico;
	private TextView txt_identificador,txt_fecha,txt_municipio,txt_info;
	private ImageView foto;
	private Drawable lienzo;
	private ImageView ic_info;
	private Cursor cursor;
	private DatabaseManager manager;
	private long id;
	private int posicion;
	private AssetManager am;
	private InputStream is;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_mostrar_cactacea);		
	
		Bundle extras=getIntent().getExtras();
		id=extras.getLong("id",1);	
		posicion=extras.getInt("posicion",1);
		manager=new DatabaseManager(this);		
		cursor=manager.query(id+"");
		cursor.moveToNext();
		
		txt_nombre=(TextView)findViewById(R.id.nombre);
		txt_nom_cientifico=(TextView)findViewById(R.id.nombre_cientifico);
		txt_identificador=(TextView)findViewById(R.id.nombre_investigador);
		txt_fecha=(TextView)findViewById(R.id.fecha);
		txt_municipio=(TextView)findViewById(R.id.municipio);
		txt_info=(TextView)findViewById(R.id.informacion);
		foto=(ImageView)findViewById(R.id.foto);
		ic_info=(ImageView)findViewById(R.id.ic_info);
		
		txt_nombre.setText(cursor.getString(cursor.getColumnIndex(manager.CN_NAME)));
		txt_nom_cientifico.setText(cursor.getString(cursor.getColumnIndex(manager.CN_NAME_SCIENTIFIC)));
		txt_identificador.setText(cursor.getString(cursor.getColumnIndex(manager.CN_IDENTIFICADOR)));
		txt_fecha.setText(cursor.getString(cursor.getColumnIndex(manager.CN_FECHA_COLECTA)));
		txt_municipio.setText(cursor.getString(cursor.getColumnIndex(manager.CN_MUNICIPIO)));
		txt_info.setText(cursor.getString(cursor.getColumnIndex(manager.CN_INFORMACION)));		
		
		try{
		am=this.getAssets();
		is=am.open("imagen_no_disponible.png");
		lienzo=Drawable.createFromStream(is, null);
		foto.setImageDrawable(lienzo);		
		is=am.open("iconos/info.png");
		lienzo=Drawable.createFromStream(is, null);
		ic_info.setImageDrawable(lienzo);
		is.close();		
		}catch(Exception e){e.printStackTrace();}
		
		finally{
		cursor.close();			
		}
	}
	
}
