package com.example.projectservices;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmailActivity extends Activity implements OnClickListener {
	Button send , cancel;
	EditText title , body;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_email);
		send=(Button) findViewById(R.id.btnsend);
		send.setOnClickListener(this);
		cancel=(Button) findViewById(R.id.btnCancel);
		cancel.setOnClickListener(this);
		
		title=(EditText) findViewById(R.id.Title);
		body=(EditText) findViewById(R.id.Message);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_email, menu);
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
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnsend:
			
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setData(Uri.parse("mailto:"));
			String [] to={"aliabdu1407@hotmail.com"};
			intent.putExtra(intent.EXTRA_EMAIL,to);
			intent.putExtra(intent.EXTRA_SUBJECT,"new android apps for you");
			intent.putExtra(intent.EXTRA_TEXT, body.toString());
			intent.setType("message/rfc822");
			startActivity(Intent.createChooser(intent, "choose your type of email"));
			break;
		case R.id.btnCancel:
			finish();
			//Toast.makeText(this, "cancel", Toast.LENGTH_LONG).show();
			
			
			break;
			
			default:
				
				Toast.makeText(this,"you have not selected any activity", Toast.LENGTH_LONG).show();
		}
		
	}
}
