package com.example.projectservices;


import com.example.projectservices.ExpandList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends Activity  {

	//Create ExpandableListView.
		ExpandableListView callcenterView;
		ImageView call;
		TextView imageview;
		public static  Context mycontext;
	
		Button lang;
		
		//public static String[] Parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //this is coming from btnlangugae layout
      
       lang=(Button) findViewById(R.id.btllang);
        callcenterView=(ExpandableListView) findViewById(R.id.ServicView);
		callcenterView.setAdapter(new ExpandList(getBaseContext()));
		mycontext=getBaseContext();	       

}	
    public static  Context getcContext(){
		return mycontext;	
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	
        //getMenuInflater().inflate(R.menu.main, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);  
        return true;
    }  
    @Override
  
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       	
        	if((item.getItemId()==R.id.selectArabic) && (ExpandList.language2==0)){
        		
        		Intent a = getIntent();
        		a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        		overridePendingTransition(0, 0);
        		a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        		finish();
        		overridePendingTransition(0, 0);
        		 
        	    finish();
				 ExpandList.language2=1;
				 
				 startActivity(a);
				
        	     }
        	
				 else if((item.getItemId()==R.id.selectEnglish)&& (ExpandList.language2==1))
				 {
						
					 Intent a = getIntent();
		        		a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		        		overridePendingTransition(0, 0);
		        		a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		        		finish();
		        		overridePendingTransition(0, 0);
		        	    finish();
					 ExpandList.language2=0;
					 	
					 startActivity(a);
					
				 }
        	item.setChecked(true);
        	if(item.getItemId()==R.id.action_settings){
        		Intent intent = new Intent(Intent.ACTION_SEND);
    			intent.setData(Uri.parse("mailto:"));
    			String [] to={"aliabdu1407@hotmail.com"};
    			intent.putExtra(intent.EXTRA_EMAIL,to);
    			//intent.putExtra(intent.EXTRA_SUBJECT,"new android apps for you");
    			//intent.putExtra(intent.EXTRA_TEXT, );
    			intent.setType("message/rfc822");
    			startActivity(Intent.createChooser(intent, "choose your type of email"));
    			
        	}
        	
				
        return super.onOptionsItemSelected(item);
        
    }
}
