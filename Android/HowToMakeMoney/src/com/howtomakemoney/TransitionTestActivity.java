package com.howtomakemoney;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.howtomakemoney.model.Tip;
import com.howtomakemoney.model.storage.DataBaseHandler;
import com.howtomakemoney.model.storage.LocalIndex;
import com.howtomakemoney.model.storage.SQLDataManager;

public class TransitionTestActivity extends ActionBarActivity {

	private DataBaseHandler dataManager;
	private Button tipHolder;
	private int index ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LocalIndex.setIndex(this, 0);
		setContentView(R.layout.activity_transition_test);
		dataManager = new SQLDataManager(this);
		// refresh the number of tips in the db		
		LocalIndex.setTipsCount(this, dataManager.countTips());
		// get the current index of tips		
		index = LocalIndex.getIndex(this);
		this.tipHolder = (Button) findViewById(R.id.tipHolder);

		Tip openTip = dataManager.GetTip(index);
		if (openTip != null){
			this.tipHolder.setText(ArrangeTip(openTip.getContent(), openTip.getAuther()));
			final Context con = this;
			this.tipHolder.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					index = LocalIndex.incrementIndex(con);
					Tip tip = dataManager.GetTip(index);
					tipHolder.setText(ArrangeTip(tip.getContent(), tip.getAuther()));
//					ExpandColapse.collapse(v);
					
				}
			});
		}


		//Outline
		//		ImageButton fab = (ImageButton) findViewById(R.id.fab);
		//Outline outline = new Outline();
		//outline.setOval(0, 0, size, size);
		//fab.setOutline(outline);  
		//		ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
		//		        @Override
		//		        public void getOutline(View view, Outline outline) {
		//		            // Or read size directly from the view's width/height
		//		            int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
		//		            outline.setOval(0, 0, size, size);
		//		        }
		//		    };
		//		fab.setOutlineProvider(viewOutlineProvider);
	}


	public String ArrangeTip(String content,String auther)
	{
		return '"' + content+ '"'+ " -" + auther;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.transition_test, menu);
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
}
