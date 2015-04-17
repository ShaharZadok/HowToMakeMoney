package com.howtomakemoney.model.storage;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class LocalIndex {

	
	private static final String INDEX_KEY = "index";
	private static final int DEFAULT_VAL = 0;
	private static final int NEG_VAL = -1;
	

	protected LocalIndex() {}

	
	public synchronized static int getIndex(Context context){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		int val =  sharedPreferences.getInt(INDEX_KEY, NEG_VAL);
		if (val < DEFAULT_VAL)
			setIndex(context, DEFAULT_VAL);
		return sharedPreferences.getInt(INDEX_KEY, DEFAULT_VAL);
	}

	public synchronized static int incrementIndex(Context context){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		// prevent the index from passing the tipCount		
		int newValue = (sharedPreferences.getInt(INDEX_KEY, DEFAULT_VAL) + 1) % getTipsCount(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(INDEX_KEY, newValue);
		editor.commit();
		return newValue;
	}
	
	public synchronized static int setIndex(Context context, int value){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(INDEX_KEY, value);
		editor.commit();
		return value;
	}
	
	
	
	private static final String TIPS_COUNT_KEY = "tip";

	
	public synchronized static int getTipsCount(Context context){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		int val =  sharedPreferences.getInt(TIPS_COUNT_KEY, NEG_VAL);
		if (val < DEFAULT_VAL)
			setTipsCount(context, DEFAULT_VAL);
		return sharedPreferences.getInt(TIPS_COUNT_KEY, DEFAULT_VAL);
	}

	public synchronized static void setTipsCount(Context context, int value){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt(TIPS_COUNT_KEY, value);
		editor.commit();
	}
	
}
