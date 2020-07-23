/**
 * 
 */
package com.project.cactus;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * @author Migue
 *
 */
public class Buscar extends Activity implements OnClickListener {
	
	private ImageView buscar;
	private EditText texto;
	private ListView lista;
	private DatabaseManager manager;
	private Cursor cursor;
	private BaseAdapter adaptador;
		
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_buscar);
		
		
		manager=new DatabaseManager(this);
		buscar=(ImageView)findViewById(R.id.ic_buscar);
		texto=(EditText)findViewById(R.id.texto_buscar);
		lista=(ListView)findViewById(R.id.lista);
		
		buscar.setOnClickListener(this);
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub				
		String elemento=texto.getText().toString();
		cursor=manager.query_name(elemento);
		adaptador=new adaptadorLista(this,cursor);
		lista.setAdapter(adaptador);		
		cursor.close();				
	}
}
