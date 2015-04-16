package com.howtomakemoney.model.storage;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class LocalIndex {

	static String INDEX_KEY = "index";
	static private Integer index =  0;

	protected LocalIndex() {}



	public static void SaveInt(String key, int value,Context context){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	
	public static int LoadInt(Context context){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		int savedValue = sharedPreferences.getInt("index", 0);
		return savedValue;
	}

}
