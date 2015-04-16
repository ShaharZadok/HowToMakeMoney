package com.howtomakemoney.model.storage;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.howtomakemoney.model.Tip;


public class SQLDataManager extends SQLiteOpenHelper implements DataBaseHandler {

	private static final int DATABASE_VERSION = 1;

	/************************************************************************
	 ************************ Tables fields names ***************************
	 ************************************************************************/
	// Database Name
	private static final String DATABASE_NAME = "HowTo";

	// global fields 
	static final String KEY_ID = "id";

	//HowTo table's names
	static final String TABLE_MONEY = "MONEY";

	//How to make money fields
	static final String KEY_CONTENT = "content";
	static final String KEY_AUTHER = "auther";
	static final String KEY_CREATE_TIME = "create_time";
	static final String KEY_IS_FAVORITE = "favorite";



	/************************************************************************
	 ********************** Tables creation queries *************************
	 ************************************************************************/

	final String CREATE_TABLE_MONEY = "CREATE TABLE if not exists " + TABLE_MONEY + "("
			+ KEY_ID + " TEXT PRIMARY KEY , " 
			+ KEY_CONTENT + " TEXT , "
			+ KEY_AUTHER + " TEXT , "
			+ KEY_CREATE_TIME + " TEXT , "
			+ KEY_IS_FAVORITE + " TEXT" +")";

	private Context context;








	/************************************************************************
	 ************************************************************************ 
	 ************************ SQL manager methods ***************************
	 ************************************************************************
	 ************************************************************************/
	/***********************************************
	 **************** Creation ********************* 
	 ***********************************************/

	/**
	 * name: SQLDataManager
	 * role: DB constructor - store context
	 */
	public SQLDataManager(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_MONEY);

	}



	/***********************************************
	 **************** Insert *********************** 
	 ***********************************************/



	@Override
	public void InsertTip(Tip tip) {

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(SQLDataManager.KEY_ID, tip.getId());
		values.put(SQLDataManager.KEY_CONTENT, tip.getContent());
		values.put(SQLDataManager.KEY_AUTHER, tip.getAuther());
		values.put(SQLDataManager.KEY_CREATE_TIME, tip.getCreateTime());
		values.put(SQLDataManager.KEY_IS_FAVORITE, tip.isFavorite());
		ContentValues group_dilemmas_table_values = new ContentValues();

		// Inserting Row
		db.insert(SQLDataManager.TABLE_MONEY, null, values);
		db.close(); // Closing database connection


	}



	/***********************************************
	 **************** Delete ***********************
	 ***********************************************/



	@Override
	public void DeleteTip(Tip tip) {
		// TODO Auto-generated method stub

	}



	/***********************************************
	 **************** Update *********************** 
	 ***********************************************/


	@Override
	public void UpdateTip(Tip tip) {
		// TODO Auto-generated method stub

	}



	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	@Override
	public Tip GetTip(int i) {
		/* this function returns a list of all the messages of a certain group */

		SQLiteDatabase db = this.getWritableDatabase();
		String tipId, tipContent, tipAuther, createTime, isFavorite;
		Tip tip = null;
		String selectVetosQuery = "SELECT * FROM " + TABLE_MONEY+ " WHERE " 
				+ KEY_ID + " = "+ '"' + i + '"';
		Cursor cursorTip = db.rawQuery(selectVetosQuery, null);
		if (!cursorTip.moveToFirst()) {
			i = 0;
			LocalIndex.SaveInt("index",i,context);
			selectVetosQuery = "SELECT * FROM " + TABLE_MONEY+ " WHERE " 
					+ KEY_ID + " = "+ '"' + i + '"';
			cursorTip = db.rawQuery(selectVetosQuery, null);
			cursorTip.moveToFirst();
		}

		tipId = cursorTip.getString(0);
		tipContent = cursorTip.getString(1);
		tipAuther = cursorTip.getString(2);
		createTime = cursorTip.getString(3);
		long tipCreateTime = Long.parseLong(createTime);
		isFavorite = cursorTip.getString(4);
		boolean tipIsFavorite = Boolean.valueOf(isFavorite);
		tip = new Tip(tipId,tipContent,tipAuther,tipCreateTime,tipIsFavorite);


		db.close();
		return tip;
	}

}
