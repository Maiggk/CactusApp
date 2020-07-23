package com.project.cactus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
                       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        
        if(id ==  R.id.acerca_de){
        	Intent i=new Intent(this,acercaDe.class);
        	startActivity(i);
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    public void consultar(View view){
    	Intent i=new Intent(this,consulta.class);
    	startActivity(i);
    }
    
    public void buscar(View view){
    	Intent i=new Intent(this,Buscar.class);
    	startActivity(i);
    }
}
