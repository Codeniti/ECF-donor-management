package com.example.sales;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "sales_directory";
	String login = "login";
	String sales = "sales_emp";
	String customer = "customer";

	public Database(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * Create the employeae table and populate it with sample data. In step
		 * 6, we will move these hardcoded statements to an XML document.
		 */
		String sql = "CREATE TABLE IF NOT EXISTS " + login + " ("
				+ "sid INTEGER PRIMARY KEY, " + "username TEXT, "
				+ "password TEXT)";
		try{
		db.execSQL(sql);
		}catch(Exception e){
			
		}
		ContentValues values = new ContentValues();
		values.put("sid", 1);
		values.put("username", "abc");
		values.put("password", "abc");
		db.insert("login", null, values);

		values.put("sid", 2);
		values.put("username", "abc1");
		values.put("password", "abc1");
		db.insert("login", null, values);

		String sql1 = "CREATE TABLE IF NOT EXISTS " + sales + " ("
				+ "sid INTEGER PRIMARY KEY, " + "meet INTEGER, "
				+ "agreed INTEGER, " + "buyed INTEGER )";
		try{
			db.execSQL(sql1);
			}catch(Exception e){
				
			}

		
		/*
		 * values.put("title", "Lead Architect"); values.put("officePhone",
		 * "617-444-1122"); values.put("cellPhone", "617-555-3344");
		 * values.put("email", "mtaylor@email.com"); values.put("managerId",
		 * "2"); db.insert("employee", "lastName", values);
		 */
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + login);
		db.execSQL("DROP TABLE IF EXISTS " + sales);
		onCreate(db);
	}

}
