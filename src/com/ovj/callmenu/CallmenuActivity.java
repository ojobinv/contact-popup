package com.ovj.callmenu;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class CallmenuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
    Button b=(Button) findViewById(R.id.button1);
    
    registerForContextMenu(b);
        
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// TODO Auto-generated method stub
    	super.onCreateContextMenu(menu, v, menuInfo);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.popup, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	
    	 AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    	    switch (item.getItemId()) {
    	        case R.id.call:
    	            //fetch number from database to variable no
    	        	String no="0000000";
    	        	
    	        	Intent dialIntent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+no));

    	        	startActivity(dialIntent);
    	        	
    	            return true;
    	        case R.id.mail:
    	           //fetch email address from database to variable mad
    	        	
    	        	String madd="ojobinv@gmail.com";
    	        	
    	        	/* Create the Intent */
    	        	final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

    	        	/* Fill it with Data */
    	        	emailIntent.setType("plain/text");
    	        	emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, madd);
    	        	emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
    	        	emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

    	        	/* Send it off to the Activity-Chooser */
    	        	startActivity(Intent.createChooser(emailIntent, "Send mail..."));
    	            
    	        	return true;
    	        default:
                      return super.onContextItemSelected(item);
    	    }
    }
}