package com.howtomakemoney.model.storage;

import com.howtomakemoney.model.Tip;

public interface DataBaseHandler {

	public abstract int countTips();
	public abstract void InsertTip(Tip tip);
	public abstract void DeleteTip(Tip tip);
	public abstract Tip GetTip(int index);
	public abstract void UpdateTip(Tip tip);
	
}
