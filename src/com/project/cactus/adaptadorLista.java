/**
 * 
 */
package com.project.cactus;

import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * @author Migue
 *
 */
public class adaptadorLista extends BaseAdapter {

	private LayoutInflater inflador;
	private TextView nombre,nombre_cientifico,valor_peligro;
	private ImageView foto;
	private Cursor cursor;
	private DatabaseManager manager;
	private Drawable image;
	private AssetManager am;
	
	
	public adaptadorLista(Context contexto){
		inflador=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		manager=new DatabaseManager(contexto);
		cursor=manager.cargarCursorCactaceas();
		am=contexto.getAssets();
	}
	
	public adaptadorLista(Context contexto,Cursor cursor){
		inflador=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);		
		this.cursor=cursor;
		am=contexto.getAssets();
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub		
		return cursor.getCount();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		cursor.moveToPosition(position);
		long id = cursor.getLong(0);
        return id; 		
	}

	@Override
	public View getView(int position, View vistaReciclada, ViewGroup parent) {
		// TODO Auto-generated method stub							
		if(vistaReciclada==null){
			vistaReciclada=inflador.inflate(R.layout.layout_elemento_consulta, null);
		}
		nombre=(TextView)vistaReciclada.findViewById(R.id.textView1);
		nombre_cientifico=(TextView)vistaReciclada.findViewById(R.id.textView2);		
		valor_peligro=(TextView)vistaReciclada.findViewById(R.id.textView4);
		foto=(ImageView)vistaReciclada.findViewById(R.id.imageView1);		
		
		cursor.moveToPosition(position);//Esta es la linea que resolvio el error!!!!!
		nombre.setText(cursor.getString(cursor.getColumnIndex(manager.CN_NAME)));
		nombre_cientifico.setText(cursor.getString(cursor.getColumnIndex(manager.CN_NAME_SCIENTIFIC)));
		valor_peligro.setText(cursor.getString(cursor.getColumnIndex(manager.CN_PELIGRO)));
		
		try{
			InputStream is=am.open("imagen_no_disponible.png");
			image=Drawable.createFromStream(is, null);
			foto.setImageDrawable(image);			
		}catch(Exception e){e.printStackTrace();}
			
		return vistaReciclada;
	}

}
