package com.howtomakemoney.view;

import java.util.Calendar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.howtomakemoney.R;
import com.howtomakemoney.TransitionTestActivity;
import com.howtomakemoney.model.Tip;
import com.howtomakemoney.model.storage.DataBaseHandler;
import com.howtomakemoney.model.storage.LocalIndex;
import com.howtomakemoney.model.storage.SQLDataManager;




public class MainActivity extends ActionBarActivity {

	private DataBaseHandler dataManager;
	private TextView tv1;
	private Context context=this;
	int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		if(LocalIndex.LoadInt(context) != 0)
//			i = LocalIndex.LoadInt(context);
//		//LocalIndex.SaveInt("index", i,context);
		dataManager = new SQLDataManager(this);
		long createTime = Calendar.getInstance().get(Calendar.MILLISECOND);
		 Tip tip0 = new Tip("0","Time is money. if you won't work, you'll save time - you will save money!",
			"S.Zadok",createTime,true);
		  Tip tip1 = new Tip("1","MONEY FOR NOTHING!!!!!",
				"O.Hadad",createTime,true);
		  Tip tip2 = new Tip("2","lo nihnas maspik or",
					"O.Hadad",createTime,true);
		  Tip tip3 = new Tip("3","Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money Money ",
					"O.Hadad <3",createTime,true);
		 dataManager.InsertTip(tip0);
		 dataManager.InsertTip(tip1);
		 dataManager.InsertTip(tip2);
		 dataManager.InsertTip(tip3);
		Tip openTip = dataManager.GetTip(i);
//		tv1 = (TextView)findViewById(R.id.tipContent);
//		tv1.setText(ArrangeTip(openTip.getContent(), openTip.getAuther()));
//		tv1.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				i = LocalIndex.LoadInt(context)+1;
//				LocalIndex.SaveInt("index", i,context);
//				Tip tip = dataManager.GetTip(i);
//				tv1.setText(ArrangeTip(tip.getContent(), tip.getAuther()));
//
//			}
//		});
		
		Intent i = new Intent(this, TransitionTestActivity.class);
		startActivity(i);
		finish();
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
		return super.onOptionsItemSelected(item);
	}
	public String ArrangeTip(String content,String auther)
	{
		return '"' + content+ '"'+ " -" + auther;
	}
}
