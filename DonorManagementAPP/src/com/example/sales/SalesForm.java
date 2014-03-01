package com.example.sales;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SalesForm extends Activity {
	EditText un, un0,un1,un2,un3;
	TextView error,username,password;
	Button btn_login;
	RadioButton rb1,rb2,rb3;
	RadioGroup rg;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	String resp;
	String errorMsg;
	boolean x,y,z;
	int sid;
	String pwd,pwd1,pwd2,pwd3,pwd4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		x=false;
		y=false;
		z=false;
				setContentView(R.layout.salesformxml);
				sid=getIntent().getIntExtra("sid", 0);
				rb1=(RadioButton)findViewById(R.id.x);
				rb2=(RadioButton)findViewById(R.id.y);
				rb3=(RadioButton)findViewById(R.id.z);
				un = (EditText) findViewById(R.id.name_edit);
				un0 = (EditText) findViewById(R.id.addr_edit);
				un1 = (EditText) findViewById(R.id.mob_edit);
				un2 = (EditText) findViewById(R.id.email_edit);
				un3 = (EditText) findViewById(R.id.donation_edit);
				btn_login = (Button) findViewById(R.id.uploadbutton);
				db = (new Database(this)).getWritableDatabase();
				rb2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						// Is the button now checked?
					    // Check which radio button was clicked
					   
					             if(rb2.isChecked())
					            {
					            	y=true;
					            	z=false;
					            	x=false;
					            }
					   
					}
					

				});
				rb1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						// Is the button now checked?
					    // Check which radio button was clicked
					   
					             if(rb1.isChecked())
					            {
					            	x=true;
					            	y=z=false;
					            }
					   
					}
					

				});
				rb3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						// Is the button now checked?
					    // Check which radio button was clicked
					   
					             if(rb3.isChecked())
					            {
					            	z=true;
					            	x=y=false;
					            }
					   
					}
					

				});
				btn_login.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						pwd=un.getText().toString();
						pwd1=un0.getText().toString();
						pwd2=un1.getText().toString();
						pwd3=un2.getText().toString();
						pwd4=un3.getText().toString();
						
						cursor = db.rawQuery("SELECT cid FROM sales_emp WHERE cid=EXISTS(select cid from sales_emp) order by cid DESC LIMIT 1", null);
						cursor.moveToFirst();
						if(!(cursor.moveToFirst()) || cursor.getCount()==0||cursor.getCount()>1){
							ContentValues values=new ContentValues();
							values.put("cid", 1);
							values.put("cname", pwd);
							values.put("addr", pwd1);
							values.put("tel", pwd2);
							values.put("email", pwd3);
							values.put("donation", pwd4);
							db.insert("sales_emp", null, values);
							cursor.moveToFirst();
						}
						else{
							ContentValues values=new ContentValues();
							values.put("cid", cursor.getInt(cursor.getColumnIndex("cid"))+1);
							values.put("cname", pwd);
							values.put("addr", pwd1);
							values.put("tel", pwd2);
							values.put("email", pwd3);
							values.put("donation", pwd4);
							db.insert("sales_emp", null, values);
							cursor.moveToFirst();
						}
						if(x)
						{
							cursor = db.rawQuery("SELECT sid FROM sales_emp WHERE sid=?",new String[]{ Integer.toString(sid)});
							cursor.moveToFirst();
							if(!(cursor.moveToFirst()) || cursor.getCount()==0||cursor.getCount()>1){
								ContentValues values=new ContentValues();
								values.put("sid", sid);
								values.put("meet", 1);
								values.put("agreed", 0);
								values.put("buyed", 0);
								db.insert("sales_emp", null, values);
								cursor.moveToFirst();
							}
							else{
								cursor = db.rawQuery("SELECT meet FROM sales_emp WHERE sid=?",new String[]{ Integer.toString(sid)});
								cursor.moveToFirst();
								ContentValues values=new ContentValues();
								values.put("meet", cursor.getInt(cursor.getColumnIndex("meet"))+1);
								db.update("sales_emp", values, "sid=sid", null);
								cursor.moveToFirst();
							}
								
						}
						else if(y)
						{
							cursor = db.rawQuery("SELECT sid FROM sales_emp WHERE sid=?",new String[]{ Integer.toString(sid)});
							cursor.moveToFirst();
							if(!(cursor.moveToFirst()) || cursor.getCount()==0||cursor.getCount()>1){
								ContentValues values=new ContentValues();
								values.put("sid", sid);
								values.put("meet", 0);
								values.put("agreed", 1);
								values.put("buyed", 0);
								db.insert("sales_emp", null, values);
								cursor.moveToFirst();
							}
							else{
								cursor = db.rawQuery("SELECT agreed FROM sales_emp WHERE sid=?",new String[]{ Integer.toString(sid)});
								cursor.moveToFirst();
								ContentValues values=new ContentValues();
								values.put("agreed", cursor.getInt(cursor.getColumnIndex("agreed"))+1);
								db.update("sales_emp", values, "sid=sid", null);
								cursor.moveToFirst();
							}
							
						}
						else if(z)
						{
							cursor = db.rawQuery("SELECT sid FROM sales_emp WHERE sid=?",new String[]{ Integer.toString(sid)});
							cursor.moveToFirst();
							if(!(cursor.moveToFirst()) || cursor.getCount()==0||cursor.getCount()>1){
								ContentValues values=new ContentValues();
								values.put("sid", sid);
								values.put("meet", 0);
								values.put("agreed", 0);
								values.put("buyed", 1);
								db.insert("sales_emp", null, values);
								cursor.moveToFirst();
							}
							else{
								cursor = db.rawQuery("SELECT buyed FROM sales_emp WHERE sid=?",new String[]{ Integer.toString(sid)});
								cursor.moveToFirst();
								ContentValues values=new ContentValues();
								values.put("buyed", cursor.getInt(cursor.getColumnIndex("buyed"))+1);
								db.update("sales_emp", values, "sid=sid", null);
								cursor.moveToFirst();
							}
						}
						Toast.makeText(SalesForm.this, "Submitted Successfully" , Toast.LENGTH_LONG).show();
						Intent at=new Intent(SalesForm.this, SalesForm.class);
                    startActivity(at);
					finish();
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
