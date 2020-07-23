/**
 * 
 */
package com.project.cactus;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView;

/**
 * @author Migue
 *
 */
public class consulta extends Activity implements OnItemClickListener{
	
	private ListView lista;	
	BaseAdapter adaptador;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_consulta);
		lista=(ListView)findViewById(R.id.listView1);
		adaptador=new adaptadorLista(this);
		
		lista.setAdapter(adaptador);
		lista.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView parent,View vista,int posicion, long id){
        Intent i = new Intent(this, mostrarCactacea.class);
        i.putExtra("id",id);      
        i.putExtra("posicion",posicion);
        startActivity(i);
    }
	
	
	
}
