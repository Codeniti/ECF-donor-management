package com.example.sales;



import com.example.sales.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText un, pw;
	TextView error,username,password;
	Button btn_login;
	RadioButton rb1,rb2;
	RadioGroup rg;
	Editable resp;
	String user;
	String pwd;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		un = (EditText) findViewById(R.id.title);
		pw = (EditText) findViewById(R.id.title1);
		btn_login = (Button) findViewById(R.id.uploadbutton);
		error = (TextView) findViewById(R.id.tv_error);
		username = (TextView) findViewById(R.id.tv_error1);
		password = (TextView) findViewById(R.id.textView1);
       
       db = (new Database(this)).getWritableDatabase();
		//rg=(RadioGroup)findViewById(R.id.radioGroup1);


		
		
		btn_login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				resp=un.getText();
			       user=resp.toString();
			       pwd=pw.getText().toString();
				cursor = db.rawQuery("SELECT sid FROM login WHERE username=? and password=?",new String[]{ user,pwd});
				if(!(cursor.moveToFirst()) || cursor.getCount()==0||cursor.getCount()>1){
					
				}
				else
				{
					if(cursor.moveToFirst()){
					Intent at=new Intent(MainActivity.this, SalesForm.class);
					
						at.putExtra("sid", cursor.getInt(cursor.getColumnIndex("sid")));
					
				
					startActivity(at);
					finish();
					}
				
				
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
